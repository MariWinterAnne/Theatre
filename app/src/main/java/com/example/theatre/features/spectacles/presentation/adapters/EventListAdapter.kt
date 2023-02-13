package com.example.theatre.features.spectacles.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.theatre.R
import com.example.theatre.core.domain.model.common.performance.Performance
import com.example.theatre.core.presentation.ext.EMPTY
import com.example.theatre.core.presentation.ext.deleteHTML
import com.example.theatre.databinding.ItemSpectacleBinding

/**
 * Адаптер для списка постановок
 *
 * @property spectacles - список постановок
 * @property onItemClicked - обработка нажатия на элемент списка
 * @author Tamerlan Mamukhov
 */

class EventListAdapter(
    private val spectacles: MutableList<Performance>,
    private val onItemClicked: (id: Int) -> Unit,
) : RecyclerView.Adapter<EventListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemSpectacleBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemSpectacleBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_spectacle, parent, false)
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context: Context = holder.binding.imageThumbnail.context
        with(holder.binding) {
            with(spectacles[position]) {
                textName.text = title.replaceFirstChar { it.uppercaseChar() }
                if (isFree == true) {
                    textPrice.text = context.getString(R.string.free)
                } else {
                    textPrice.text = price
                }
                val imageURL =
                    if (images?.isNotEmpty() == true) images.first().imageURL.orEmpty() else String.EMPTY
                if (imageURL.isNotEmpty()) {
                    Glide
                        .with(context)
                        .load(imageURL)
                        .into(imageThumbnail)
                }
                textDescription.text = description.orEmpty().deleteHTML()
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
