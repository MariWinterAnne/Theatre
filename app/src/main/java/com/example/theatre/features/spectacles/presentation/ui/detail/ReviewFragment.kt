package com.example.theatre.features.spectacles.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.theatre.R
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.core.domain.model.PerformancePlaceLocation
import com.example.theatre.core.domain.model.PerformancePlace
import com.example.theatre.databinding.FragmentReviewBinding
import com.example.theatre.core.utils.PerformanceDateFormatter
import com.example.theatre.core.utils.StringUtils.EMPTY
import com.example.theatre.core.utils.toListOfActorsInPerformance
import com.example.theatre.features.spectacles.presentation.ui.detail.EventFragment.Companion.event_id
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Фрагмент с отображением деталей места постановки
 *
 * @author Marianna Sabanchieva
 */

class ReviewFragment : Fragment() {

    companion object {
        const val DETAILS_TAB = 1
        const val DETAILS = "Детали"
        fun newInstance(): ReviewFragment {
            return ReviewFragment()
        }
    }

    private lateinit var binding: FragmentReviewBinding
    private val spectacleViewModel by sharedViewModel<SpectacleDetailsViewModel>()
    private val dateFormatter by inject<PerformanceDateFormatter>()
    private lateinit var cityName: String
    private lateinit var gaps: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_review, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentReviewBinding.bind(view)
        gaps = getString(R.string.gaps)
        with(spectacleViewModel) {
            arguments?.run { init(getInt(event_id)) }
            spectacleDetailLoaded.observe(viewLifecycleOwner, ::setDetails)
            cityLoaded.observe(viewLifecycleOwner, ::setCity)
            placeLoaded.observe(viewLifecycleOwner, ::setPlace)
        }
    }

    private fun setDetails(eventDetails: Performance) {
        with(binding) {
            textDatetime.text = getString(R.string.event_date_time)
            textPlace.text = getString(R.string.place)
            textParticipants.text = getString(R.string.actors)
            with(eventDetails) {
                textAgeRestriction.text = ageRestriction
                textEventStartEnd.text = dateFormatter.getUpcomingPerformanceDates(dates)
                textParticipantsList.text = participants?.toListOfActorsInPerformance(requireContext())
            }
        }
    }

    private fun setCity(city: PerformancePlaceLocation) {
        cityName = city.name.toString()
    }

    private fun setPlace(place: PerformancePlace) {
        with(binding) {
            with(place) {
                textPlaceTitle.text = title.orEmpty().replaceFirstChar { it.uppercaseChar() }
                textPlaceSubway.text = subway
                textPlaceAddress.text = "$cityName$gaps$address"
                textPlacePhone.text = phone
                val url = if (foreignUrl?.isNotEmpty() == true) foreignUrl else String.EMPTY
                textPlaceSite.text = url
                if (isClosed == true) {
                    textPlaceIsclosed.text = getString(R.string.place_is_closed)
                }
            }
        }
    }
}
