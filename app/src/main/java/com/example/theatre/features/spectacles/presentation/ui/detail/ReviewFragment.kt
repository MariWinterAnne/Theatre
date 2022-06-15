package com.example.theatre.features.spectacles.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.theatre.R
import com.example.theatre.core.data.model.PerformancePlace
import com.example.theatre.core.data.model.PerformancePlaceLocation
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.databinding.FragmentReviewBinding
import com.example.theatre.features.info.presentation.ui.detail.RoleType.*
import com.example.theatre.core.presentation.utils.DateUtils
import com.example.theatre.core.presentation.utils.Default.orDefault
import com.example.theatre.network.Constants.TIME_CONST
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Фрагмент с отображением деталей места постановки
 *
 * @author Marianna Sabanchieva
 */

class ReviewFragment : Fragment() {

    companion object {
        private const val event_id = "id"
        fun newInstance(): ReviewFragment {
            return ReviewFragment()
        }
    }

    private lateinit var binding: FragmentReviewBinding
    private val spectacleViewModel by viewModel<SpectacleDetailsViewModel>()
    private lateinit var cityName: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_review, container, false)

        arguments?.run { spectacleViewModel.init(getInt(event_id)) }
        spectacleViewModel.spectacleDetailLoaded.observe(viewLifecycleOwner, ::setDetails)
        spectacleViewModel.cityLoaded.observe(viewLifecycleOwner, ::setCity)
        spectacleViewModel.placeLoaded.observe(viewLifecycleOwner, ::setPlace)

        return binding.root
    }

    private fun setDetails(eventDetails: Performance) {
        with(binding) {
            textDatetime.text = getString(R.string.event_date_time)
            textPlace.text = getString(R.string.place)
            textParticipants.text = getString(R.string.actors)
            with(eventDetails) {
                textAgeRestriction.text = age_restriction
                for (i in 0 until dates.size) {
                    val startDate = dates[i].start.orDefault().toLong() * TIME_CONST
                    if (startDate >= DateUtils.currentTimeToLong()) {
                        textEventStartEnd.append(
                            dates[i].start.orDefault().let { dates[i].end.orDefault().let { it1 ->
                                DateUtils.convertLongToTime(it, it1) } } + "\n")
                    }
                }
                var role = getString(R.string.empty)
                for (i in 0 until participants.size) {
                    when (participants[i].role?.slug) {
                        Actor.title -> role = getString(Actor.resId)
                        Director.title -> role = getString(Director.resId)
                        Musician.title -> role = getString(Musician.resId)
                        Screenwriter.title -> role = getString(Screenwriter.resId)
                        Stage.title -> role = getString(Stage.resId)
                        Unknown.title -> role = getString(Unknown.resId)
                    }
                    textParticipantsList.append(participants[i].agent_model?.title + getString(R.string.gaps) + role + "\n")
                }
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
                ((cityName + getString(R.string.gaps)).plus(address)).also {
                    textPlaceAddress.text = it
                }
                (getString(R.string.tel).plus(phone)).also {
                    textPlacePhone.text = it
                }
                (getString(R.string.website).plus(foreign_url)).also {
                    textPlaceSite.text = it
                }
                if (is_closed == true) {
                    textPlaceIsclosed.text = getString(R.string.place_is_closed)
                }
            }
        }
    }
}
