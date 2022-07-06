package com.example.theatre.features.spectacles.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.theatre.R
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.core.presentation.utils.EMPTY
import com.example.theatre.core.presentation.utils.deleteHTML
import com.example.theatre.databinding.FragmentSpectaclesItemBinding
import com.example.theatre.network.Constants.ISFREE

/**
 * Адаптер для списка постановок
 *
 * @property spectacles - список постановок
 * @property onItemClicked - обработка нажатия на элемент списка
 * @author Marianna Sabanchieva
 */

class EventListAdapter(
    private val spectacles: MutableList<Performance>,
    private val onItemClicked: (id: Int) -> Unit,
) : RecyclerView.Adapter<EventListAdapter.ViewHolder>() {

    class ViewHolder(val binding: FragmentSpectaclesItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            FragmentSpectaclesItemBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_spectacles_item, parent, false)
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context: Context = holder.binding.imageThumbnail.context
        with(holder.binding) {
            with(spectacles[position]) {
                textName.text = title.replaceFirstChar { it.uppercaseChar() }
                if (is_free == true) {
                    textPrice.text = ISFREE
                } else {
                    textPrice.text = price
                }
                val imageURL = if (images.isNotEmpty()) images.first().image.orEmpty() else String.EMPTY
                if (imageURL.isNotEmpty()) {
                    Glide
                        .with(context)
                        .load(imageURL)
                        .into(imageThumbnail)
                }
                textDescription.text = (description.orEmpty()).deleteHTML()
                root.setOnClickListener {
                    onItemClicked(id)
                }
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
