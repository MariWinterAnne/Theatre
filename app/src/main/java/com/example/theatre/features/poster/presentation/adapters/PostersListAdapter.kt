package com.example.theatre.features.poster.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Класс для списка афиш
 *
 * @property spectacles
 * @property onItemClicked
 * @author Tamerlan Mamukhov on 2022-05-28
 */
class PostersListAdapter(
    private val count: Int,
    private val fm: FragmentManager,
    private val lc: Lifecycle
) : FragmentStateAdapter(fm, lc) {
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun createFragment(position: Int): Fragment {
        TODO("Not yet implemented")
    }

}
//class PostersListAdapter(
//    private val spectacles: MutableList<Performance>,
//    private val onItemClicked: (id: Int) -> Unit,
//) : RecyclerView.Adapter<PostersListAdapter.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(
//            FragmentSpectaclesItemBinding.bind(
//                LayoutInflater.from(parent.context)
//                    .inflate(R.layout.fragment_spectacles_item, parent, false)
//            )
//        )
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        with(holder.binding) {
//            val poster = spectacles[position]
//
//            with(poster) {
//                textName.text = title?.replaceFirstChar { it.uppercaseChar() }
//
//                if (is_free == true) {
//                    textPrice.text = PosterConstants.FREE
//                } else {
//                    textPrice.text = poster.price
//                }
//
//                val imageURL =
//                    if (images.isNotEmpty()) images.first().image.orEmpty() else ""
////                String.EMPTY в core пакете. Применю после merge
//                if (imageURL.isNotEmpty()) {
//                    Picasso.get()
//                        .load(imageURL)
//                        .into(imageThumbnail)
//                }
//
////                textDescription.text = (description.orEmpty()).deleteHTML()
////Функция deleteHTML в utils классе от Марианны. Применю после merge
//                root.setOnClickListener {
//                    id?.let { it1 -> onItemClicked(it1) }
//                }
//            }
//
//        }
//    }
//
//    override fun getItemCount(): Int = spectacles.size
//
//    class ViewHolder(val binding: FragmentSpectaclesItemBinding) :
//        RecyclerView.ViewHolder(binding.root)
//
//    fun setSpectacles(spectacleList: List<Performance>) {
//        spectacles.clear()
//        spectacles.addAll(spectacleList)
//        notifyDataSetChanged()
//    }
//}