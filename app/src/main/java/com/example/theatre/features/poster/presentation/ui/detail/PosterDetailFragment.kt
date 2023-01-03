package com.example.theatre.features.poster.presentation.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.theatre.core.utils.StringUtils.EMPTY
import com.example.theatre.databinding.FragmentPosterDetailBinding
import com.example.theatre.features.poster.domain.model.PosterDetails
import com.example.theatre.features.poster.presentation.adapters.PosterDetailsViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * Фрагмент деталей афиши
 *
 * @author Tamerlan Mamukhov on 2022-05-28
 */
class PosterDetailFragment : Fragment() {
    private lateinit var adapter: PosterDetailsViewPagerAdapter
    private lateinit var binding: FragmentPosterDetailBinding
    private lateinit var fragmentsList: ArrayList<Fragment>


    private val viewModel by sharedViewModel<PosterDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPosterDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentsList = arrayListOf(
            PosterDescriptionFragment(),
            PosterReviewFragment()
        )

        adapter = PosterDetailsViewPagerAdapter(
            fragmentsList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        with(binding) {
            content.viewPager.adapter = adapter
            TabLayoutMediator(content.tabs, content.viewPager) { tabs, position ->
                tabs.text = getTitle(position)
            }.attach()
        }

        arguments?.run { viewModel.init(getInt(poster_id)) }

        viewModel.posterDetailedLoaded.observe(viewLifecycleOwner, ::setDetails)
    }

    private fun setDetails(posterDetails: PosterDetails) {
        with(binding.content) {
            textName.text = posterDetails?.shortTitle.orEmpty().replaceFirstChar { it.uppercaseChar() }

            val imageURL =
                if (posterDetails?.images?.isNotEmpty() == true) posterDetails?.images.first().imageURL.orEmpty() else String.EMPTY

            if (imageURL.isNotEmpty()) {
                context?.let {
                    Glide
                        .with(it)
                        .load(imageURL)
                        .into(imageThumbnail)

                    Glide
                        .with(it)
                        .load(imageURL)
                        .into(binding.imageLarge)
                }
            }
        }
    }

    private fun getTitle(position: Int) = when (position) {
        0 -> "Информация"
        1 -> "Детали"
        else -> "Некст"
    }

    companion object {
        const val poster_id = "poster_id"
    }

}