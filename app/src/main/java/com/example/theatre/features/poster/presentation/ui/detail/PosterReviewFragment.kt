package com.example.theatre.features.poster.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.theatre.R
import com.example.theatre.core.presentation.PerformanceDateFormatter
import com.example.theatre.core.presentation.ext.toListOfActorsInPerformance
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.core.presentation.model.handleContents
import com.example.theatre.core.presentation.ui.ViewBindingFragment
import com.example.theatre.databinding.FragmentPosterDescriptionBinding
import com.example.theatre.databinding.FragmentPosterReviewBinding
import com.example.theatre.features.poster.domain.model.PosterDetails
import com.example.theatre.features.poster.presentation.ui.detail.PosterDetailFragment.Companion.poster_id
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * @author Tamerlan Mamukhov
 * @created 2022-08-25
 */
class PosterReviewFragment : ViewBindingFragment<FragmentPosterReviewBinding>() {
    private val viewModel by sharedViewModel<PosterDetailsViewModel>()

    private val dateFormatter by inject<PerformanceDateFormatter>()

    override val initBinding: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> FragmentPosterReviewBinding
        get() = FragmentPosterReviewBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.run { viewModel.getPoster(getInt(poster_id)) }

        viewModel.posterDetailedLoaded.observe(viewLifecycleOwner, ::handlePosterDetails)
    }

    private fun handlePosterDetails(contentResultState: ContentResultState) =
        contentResultState.handleContents(
            onStateSuccess = { setDetails(it as PosterDetails) },
            onStateError = {}
        )

    private fun setDetails(posterDetails: PosterDetails) =
        with(nonNullBinding) {
            textDatetime.text = getString(R.string.event_date_time)
            textPlace.text = getString(R.string.place)
            textParticipants.text = getString(R.string.actors)
            with(posterDetails) {
                textAgeRestriction.text = ageRestriction
                textEventStartEnd.text = dateFormatter.getUpcomingPerformanceDates(dates)
                textParticipantsList.text =
                    participants?.toListOfActorsInPerformance(requireContext())
                textPlaceSite.text = siteUrl
            }
        }
}