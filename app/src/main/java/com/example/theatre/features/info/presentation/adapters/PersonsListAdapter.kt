package com.example.theatre.features.info.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.theatre.R
import com.example.theatre.databinding.FragmentSpectaclesItemBinding
import com.example.theatre.features.spectacles.domain.model.Performance

class PersonsListAdapter(
    val spectacles: MutableList<Performance>,
    private val onItemClicked: (id:Int) -> Unit
) :
    RecyclerView.Adapter<PersonsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentSpectaclesItemBinding.bind(LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_spectacles_item, parent, false))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textName.text = spectacles[position].title
        holder.binding.root.setOnClickListener {
            //onItemClicked(spectacles[position].id)
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
