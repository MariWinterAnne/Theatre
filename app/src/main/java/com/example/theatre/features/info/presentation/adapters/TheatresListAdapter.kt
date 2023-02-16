package com.example.theatre.features.info.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.theatre.R
import com.example.theatre.core.presentation.ext.EMPTY
import com.example.theatre.core.presentation.ext.deleteHTML
import com.example.theatre.databinding.ItemTheatreBinding
import com.example.theatre.features.info.domain.model.theatre.Theatre

/**
 * Адаптер для списка театров
 *
 * @property theatres - список театров
 * @property onItemClicked - обработка нажатия на элемент списка
 *
 * @author Tamerlan Mamukhov
 */

class TheatresListAdapter(
    private val theatres: MutableList<Theatre>,
    private val onItemClicked: (id: Int) -> Unit,
) : RecyclerView.Adapter<TheatresListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemTheatreBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemTheatreBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_theatre, parent, false)
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context: Context = holder.binding.imageThumbnail.context
        with(holder.binding) {
            with(theatres[position]) {
                textName.text = title.replaceFirstChar { it.uppercaseChar() }
                if (isClosed == true) {
                    textClosed.text = context.getString(R.string.closed)
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

    override fun getItemCount(): Int = theatres.size

    fun setTheatres(theatreList: List<Theatre>) {
        if (theatreList.isNotEmpty()) {
            theatres.clear()
            theatres.addAll(theatreList)
            notifyDataSetChanged()
        }
    }
}
