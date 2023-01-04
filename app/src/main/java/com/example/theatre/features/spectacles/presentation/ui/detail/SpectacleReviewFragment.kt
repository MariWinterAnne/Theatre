package com.example.theatre.features.spectacles.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.theatre.R
import com.example.theatre.core.domain.models.Performance
import com.example.theatre.core.domain.models.PerformancePlace
import com.example.theatre.core.domain.models.PerformancePlaceLocation
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.core.presentation.model.handleContents
import com.example.theatre.core.utils.PerformanceDateFormatter
import com.example.theatre.core.utils.StringUtils.EMPTY
import com.example.theatre.core.utils.toListOfActorsInPerformance
import com.example.theatre.databinding.FragmentReviewBinding
import com.example.theatre.features.spectacles.presentation.ui.detail.SpectacleDetailsFragment.Companion.event_id
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Фрагмент с отображением деталей места постановки
 *
 * @author Marianna Sabanchieva
 */

class SpectacleReviewFragment : Fragment() {

    companion object {
        const val DETAILS_TAB = 1
        const val DETAILS = "Детали"
        fun newInstance(): SpectacleReviewFragment {
            return SpectacleReviewFragment()
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
            spectacleDetailLoaded.observe(viewLifecycleOwner, ::handleInfo)
            cityLoaded.observe(viewLifecycleOwner, ::handleInfo)
            placeLoaded.observe(viewLifecycleOwner, ::handleInfo)
        }
    }

    private fun handleInfo(contentResultState: ContentResultState) {
        contentResultState.handleContents(
            onStateSuccess = {
                when (it) {
                    is Performance -> {
                        setDetails(it)
                    }
                    is PerformancePlaceLocation -> {
                        setCity(it)
                    }
                    is PerformancePlace -> {
                        setPlace(it)
                    }
                }
            },
            onStateError = {

            }
        )
    }


    private fun setDetails(eventDetails: Performance) {
        with(binding) {
            textDatetime.text = getString(R.string.event_date_time)
            textPlace.text = getString(R.string.place)
            textParticipants.text = getString(R.string.actors)
            with(eventDetails) {
                textAgeRestriction.text = ageRestriction
                textEventStartEnd.text = dateFormatter.getUpcomingPerformanceDates(dates)
                textParticipantsList.text =
                    participants?.toListOfActorsInPerformance(requireContext())
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
