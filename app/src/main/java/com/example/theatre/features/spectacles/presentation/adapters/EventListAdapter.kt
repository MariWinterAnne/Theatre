package com.example.theatre.features.spectacles.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.theatre.R
import com.example.theatre.databinding.FragmentSpectaclesItemBinding
import com.example.theatre.features.spectacles.domain.model.Performance
import com.squareup.picasso.Picasso

class EventListAdapter(
    val spectacles: MutableList<Performance>,
    private val onItemClicked: (id: Int) -> Unit,
) :
    RecyclerView.Adapter<EventListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentSpectaclesItemBinding.bind(LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_spectacles_item, parent, false))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            textName.text = spectacles[position].title!!.replaceFirstChar { it.uppercaseChar() }
            if (spectacles[position].is_free == true) {
                textPrice.text = "бесплатно"
            } else {
                textPrice.text = spectacles[position].price
            }
            Picasso.get()
                .load(spectacles[position].images[0].image.toString())
                .into(imageThumbnail)
            textDescription.text = HtmlCompat.fromHtml(spectacles[position].description!!, HtmlCompat.FROM_HTML_MODE_LEGACY)
            root.setOnClickListener {
                onItemClicked(spectacles[position].id!!)
            }
        }
    }

    override fun getItemCount(): Int = spectacles.size

    inner class ViewHolder(val binding: FragmentSpectaclesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    fun setSpectacles(spectacleList: List<Performance>) {
        spectacles.clear()
        spectacles.addAll(spectacleList)
        notifyDataSetChanged()
    }
}
