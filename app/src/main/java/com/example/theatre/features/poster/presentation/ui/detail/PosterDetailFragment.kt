package com.example.theatre.features.poster.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.theatre.core.presentation.ext.EMPTY
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.core.presentation.model.handleContents
import com.example.theatre.core.presentation.model.refreshPage
import com.example.theatre.core.presentation.ui.ViewBindingFragment
import com.example.theatre.databinding.FragmentPosterDetailBinding
import com.example.theatre.features.poster.domain.model.PosterDetails
import com.example.theatre.features.poster.presentation.adapters.PosterDetailsViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


/**
 * Фрагмент деталей афиши
 *
 * @author Tamerlan Mamukhov on 2022-05-28
 */
class PosterDetailFragment : ViewBindingFragment<FragmentPosterDetailBinding>() {
    private lateinit var adapter: PosterDetailsViewPagerAdapter
    private lateinit var fragmentsList: ArrayList<Fragment>

    private val viewModel by sharedViewModel<PosterDetailsViewModel>()

    override val initBinding: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> FragmentPosterDetailBinding
        get() = FragmentPosterDetailBinding::inflate

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

        with(nonNullBinding) {
            content.viewPager.adapter = adapter
            TabLayoutMediator(content.tabs, content.viewPager) { tabs, position ->
                tabs.text = getTitle(position)
            }.attach()
        }

        arguments?.run { viewModel.getPoster(getInt(poster_id)) }

        viewModel.posterDetailedLoaded.observe(viewLifecycleOwner, ::handlePoster)
    }


    private fun handlePoster(contentResultState: ContentResultState) {
        contentResultState.refreshPage(nonNullBinding.detailsContent, nonNullBinding.progressBar2)
        contentResultState.handleContents(
            onStateSuccess = {
                setDetails(it as PosterDetails)
            },
            onStateError = {

            }
        )
    }

    private fun setDetails(posterDetails: PosterDetails) {

        with(nonNullBinding.content) {
            with(posterDetails) {
                textName.text =
                    posterDetails.shortTitle.orEmpty().replaceFirstChar { it.uppercaseChar() }

                val imageURL = images?.first()?.imageURL.orEmpty()

                if (imageURL.isNotEmpty()) {
                    context?.let {
                        Glide
                            .with(it)
                            .load(imageURL)
                            .into(imageThumbnail)

                        Glide
                            .with(it)
                            .load(imageURL)
                            .into(nonNullBinding.imageLarge)
                    }

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