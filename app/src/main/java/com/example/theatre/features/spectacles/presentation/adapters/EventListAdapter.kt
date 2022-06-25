package com.example.theatre.features.spectacles.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.theatre.R
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.core.presentation.utils.deleteHTML
import com.example.theatre.databinding.FragmentSpectaclesItemBinding

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
        val context: Context = holder.binding.imageThumbnail.context
        with(holder.binding) {
            try { textName.text = spectacles[position].title.replaceFirstChar { it.uppercaseChar() } } catch (e: NumberFormatException) { root.context.getString(R.string.empty) }
            if (spectacles[position].is_free == true) {
                textPrice.text = root.context.getString(R.string.free)
            } else {
                textPrice.text = spectacles[position].price
            }
            try {
                val img = spectacles[position].images.first().image.toString()
                Glide
                    .with(context)
                    .load(img)
                    .into(imageThumbnail)
            } catch (e: NumberFormatException) { root.context.getString(R.string.empty) }
            textDescription.text = (spectacles[position].description.orEmpty()).deleteHTML()
            root.setOnClickListener {
                onItemClicked(spectacles[position].id)
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
