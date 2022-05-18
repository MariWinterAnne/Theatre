package com.example.theatre.features.info.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.theatre.R
import com.example.theatre.databinding.FragmentTheatresItemBinding
import com.example.theatre.features.info.domain.model.Theatre
import com.squareup.picasso.Picasso

class TheatresListAdapter(
    val theatres: MutableList<Theatre>,
    private val onItemClicked: (id: Int) -> Unit,
) :
    RecyclerView.Adapter<TheatresListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentTheatresItemBinding.bind(LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_theatres_item, parent, false))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            textName.text = theatres[position].title!!.replaceFirstChar { it.uppercaseChar() }
            if (theatres[position].isClosed == true) {
                textClosed.text = "закрыто"
            }
            Picasso.get()
                .load(theatres[position].images[0].image.toString())
                .into(imageThumbnail)
            textDescription.text = HtmlCompat.fromHtml(theatres[position].description!!,
                HtmlCompat.FROM_HTML_MODE_LEGACY)
            root.setOnClickListener {
                onItemClicked(theatres[position].id!!)
            }
        }
    }

    override fun getItemCount(): Int = theatres.size

    class ViewHolder(val binding: FragmentTheatresItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun setTheatres(theatreList: List<Theatre>) {
        theatres.clear()
        theatres.addAll(theatreList)
        notifyDataSetChanged()
    }
}
