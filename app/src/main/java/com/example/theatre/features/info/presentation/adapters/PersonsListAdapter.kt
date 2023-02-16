package com.example.theatre.features.info.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.theatre.R
import com.example.theatre.core.presentation.ext.EMPTY
import com.example.theatre.core.presentation.ext.deleteHTML
import com.example.theatre.databinding.ItemPersonBinding
import com.example.theatre.core.domain.model.common.agent.Agent

/**
 * Адаптер для списка актеров
 *
 * @property persons - список актеров
 * @property onItemClicked - обработка нажатия на элемент списка
 *
 * @author Tamerlan Mamukhov
 */

class PersonsListAdapter(
    private val persons: MutableList<Agent>,
    private val onItemClicked: (id: Int) -> Unit,
) : RecyclerView.Adapter<PersonsListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemPersonBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemPersonBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_person, parent, false)
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context: Context = holder.binding.imageThumbnail.context
        with(holder.binding) {
            with(persons[position]) {
                textName.text = title
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

    override fun getItemCount(): Int = persons.size

    fun setPersons(personList: List<Agent>) {
        if (personList.isNotEmpty()) {
            persons.clear()
            persons.addAll(personList)
            notifyDataSetChanged()
        }
    }
}
