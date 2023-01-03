package com.example.theatre.features.poster.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.theatre.R
import com.example.theatre.core.utils.StringUtils.deleteHTML
import com.example.theatre.databinding.ItemPosterBriefInfoBinding
import com.example.theatre.features.poster.domain.model.PosterBriefItem

/**
 * Адаптер кратких афиш
 *
 * @property onItemClicked  слушатель нажатия на элемент списка
 * @author Tamerlan Mamukhov on 2022-08-16
 */
class PosterBriefItemAdapter(
    private val onItemClicked: (id: Int) -> Unit
) : RecyclerView.Adapter<PosterBriefItemAdapter.ViewHolder>() {

    private var data: List<PosterBriefItem> = mutableListOf()

    class ViewHolder(val binding: ItemPosterBriefInfoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemPosterBriefInfoBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_poster_brief_info, parent, false)
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context: Context = holder.binding.placeImage.context

        with(holder.binding) {
            with(data[position]) {
                textTitle.text = title?.replaceFirstChar { it.uppercaseChar() }

                val imageUrl = image?.imageURL.orEmpty()

                if (imageUrl.isNotEmpty()) {
                    Glide
                        .with(context)
                        .load(imageUrl)
                        .into(placeImage)
                }

                textDescription.text = description.orEmpty().deleteHTML()
                textTitle.setOnClickListener {
                    onItemClicked(id)
                }

            }
        }
    }

    override fun getItemCount(): Int = data.size

    fun setData(data: List<PosterBriefItem>) {
        if (data.isNotEmpty()) {
            this.data = data
        }
    }
}