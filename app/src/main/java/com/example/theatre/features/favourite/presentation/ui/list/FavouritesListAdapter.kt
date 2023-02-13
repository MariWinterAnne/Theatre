package com.example.theatre.features.favourite.presentation.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.theatre.R
import com.example.theatre.databinding.ItemPersonBinding
import com.example.theatre.databinding.ItemTheatreBinding
import com.example.theatre.features.favourite.domain.model.FavouriteStuff

class FavouritesListAdapter(
    private val onItemClick: (id: Int) -> Unit
) : RecyclerView.Adapter<FavouritesListAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root)

    private var favourites: MutableList<FavouriteStuff> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemPersonBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(favourites[position]) {

        }
    }

    override fun getItemCount(): Int = favourites.size

    fun setFavourites(list: List<FavouriteStuff>) {
        favourites.clear()
        favourites.addAll(list)
    }


}