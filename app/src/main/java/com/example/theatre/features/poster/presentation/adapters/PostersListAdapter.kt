package com.example.theatre.features.poster.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.theatre.R
import com.example.theatre.databinding.FragmentSpectaclesItemBinding
import com.example.theatre.features.poster.misc.PosterConstants
import com.example.theatre.features.spectacles.domain.model.Performance
import com.example.theatre.features.spectacles.presentation.adapters.EventListAdapter
import com.squareup.picasso.Picasso
import java.lang.NumberFormatException

/**
 * Класс для списка афиш
 *
 * @property spectacles
 * @property onItemClicked
 * @author Tamerlan Mamukhov on 2022-05-28
 */
class PostersListAdapter(
    private val spectacles: MutableList<Performance>,
    private val onItemClicked: (id: Int) -> Unit,
) : RecyclerView.Adapter<PostersListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentSpectaclesItemBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_spectacles_item, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            val poster = spectacles[position]
            textName.text = poster.title?.replaceFirstChar { it.uppercaseChar() }

            if (poster.is_free == true) {
                textPrice.text = PosterConstants.FREE
            } else {
                textPrice.text = poster.price
            }

            try {
                val pic = poster.images.first().image.toString()
                Picasso.get()
                    .load(pic)
                    .into(imageThumbnail)
            } catch (e: NumberFormatException) { root.context.getString(R.string.empty_icon) }

            textDescription.text = poster.description?.let {
                HtmlCompat.fromHtml(
                    it,
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            }
            root.setOnClickListener {
                poster.id?.let { it1 -> onItemClicked(it1) }
            }
        }
    }

    override fun getItemCount(): Int = spectacles.size

    class ViewHolder(val binding: FragmentSpectaclesItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun setSpectacles(spectacleList: List<Performance>) {
        spectacles.clear()
        spectacles.addAll(spectacleList)
        notifyDataSetChanged()
    }
}