package com.example.theatre.features.spectacles.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.theatre.R
import com.example.theatre.databinding.FragmentSpectaclesItemBinding
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.core.presentation.utils.Default.orDefault
import com.example.theatre.core.presentation.utils.HtmlUtils.deleteHTML
import com.example.theatre.network.Constants.ISFREE
import com.squareup.picasso.Picasso

/**
 * Адаптер для списка постановок
 *
 * @property spectacles - список постановок
 * @property onItemClicked - обработка нажатия на элемент списка
 * @author Marianna Sabanchieva
 */

class EventListAdapter(
    val spectacles: MutableList<Performance>,
    private val onItemClicked: (id: Int) -> Unit,
) : RecyclerView.Adapter<EventListAdapter.ViewHolder>() {

    class ViewHolder(val binding: FragmentSpectaclesItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            FragmentSpectaclesItemBinding.bind(LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_spectacles_item, parent, false))
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            textName.text = spectacles[position].title.orEmpty().replaceFirstChar { it.uppercaseChar() }
            if (spectacles[position].is_free == true) {
                textPrice.text = ISFREE
            } else {
                textPrice.text = spectacles[position].price
            }
            Picasso.get()
                .load(spectacles[position].images.first().image.toString())
                .into(imageThumbnail)
            textDescription.text = deleteHTML(spectacles[position].description.orEmpty())
            root.setOnClickListener {
                onItemClicked(spectacles[position].id.orDefault())
            }
        }
    }

    override fun getItemCount(): Int = spectacles.size

    fun setSpectacles(spectacleList: List<Performance>) {
        if (spectacleList.isNotEmpty()) {
            spectacles.clear()
            spectacles.addAll(spectacleList)
            notifyDataSetChanged()
        }
    }
}
