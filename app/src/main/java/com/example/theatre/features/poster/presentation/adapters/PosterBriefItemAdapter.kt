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

class PosterBriefItemAdapter(
    private val data: MutableList<PosterBriefItem>,
    private val onItemClicked: (id: Int) -> Unit
) : RecyclerView.Adapter<PosterBriefItemAdapter.ViewHolder>() {

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
        val item = data[position]

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
                root.setOnClickListener {
                    onItemClicked(id)
                }

            }
        }
    }

    override fun getItemCount(): Int = data.size

    fun setData(list: List<PosterBriefItem>) {
        if (list.isNotEmpty()) {
            data.clear()
            data.addAll(list)
            notifyDataSetChanged()
        }
    }
}