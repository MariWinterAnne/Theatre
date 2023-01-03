package com.example.theatre.features.poster.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.theatre.R
import com.example.theatre.core.utils.PerformanceDateFormatter
import com.example.theatre.core.utils.toListOfActorsInPerformance
import com.example.theatre.databinding.FragmentPosterReviewBinding
import com.example.theatre.features.poster.domain.model.PosterDetails
import com.example.theatre.features.poster.presentation.ui.detail.PosterDetailFragment.Companion.poster_id
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * @author Tamerlan Mamukhov
 * @created 2022-08-25
 */
class PosterReviewFragment : Fragment() {
    private lateinit var binding: FragmentPosterReviewBinding
    private val viewModel by sharedViewModel<PosterDetailsViewModel>()

    private val dateFormatter by inject<PerformanceDateFormatter>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPosterReviewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.run { viewModel.init(getInt(poster_id)) }

        viewModel.posterDetailedLoaded.observe(viewLifecycleOwner, ::setDetails)
    }

    private fun setDetails(posterDetails: PosterDetails) =
        with(binding) {
            textDatetime.text = getString(R.string.event_date_time)
            textPlace.text = getString(R.string.place)
            textParticipants.text = getString(R.string.actors)
            with(posterDetails) {
                textAgeRestriction.text = ageRestriction
                textEventStartEnd.text = dateFormatter.getUpcomingPerformanceDates(dates)
                textParticipantsList.text = participants?.toListOfActorsInPerformance(requireContext())
                textPlaceSite.text = siteUrl
            }
        }
}