package com.example.theatre.features.info.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.theatre.R
import com.example.theatre.databinding.FragmentPersonsItemBinding
import com.example.theatre.features.info.domain.model.Agent
import com.squareup.picasso.Picasso

//TODO DiffUtils
class PersonsListAdapter(
    val persons: MutableList<Agent>,
    private val onItemClicked: (id:Int) -> Unit
): RecyclerView.Adapter<PersonsListAdapter.ViewHolder>() {

    class ViewHolder(val binding: FragmentPersonsItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            FragmentPersonsItemBinding.bind(LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_persons_item, parent, false))
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            textName.text = persons[position].title
            Picasso.get()
                .load(persons[position].images.first().image.toString())
                .into(imageThumbnail)
            textDescription.text =
                HtmlCompat.fromHtml(persons[position].description.orEmpty(), HtmlCompat.FROM_HTML_MODE_LEGACY)
            root.setOnClickListener {
                onItemClicked(persons[position].id.orDefault())
            }
        }
    }

    fun Int?.orDefault(value: Int = -1) = this ?: value

    override fun getItemCount(): Int = persons.size

    fun setPersons(personList: List<Agent>) {
        if (personList.isNotEmpty()) {
            persons.clear()
            persons.addAll(personList)
            notifyDataSetChanged()
        }
    }
}
