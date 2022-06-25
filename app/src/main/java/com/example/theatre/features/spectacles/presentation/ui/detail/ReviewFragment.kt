package com.example.theatre.features.spectacles.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.theatre.R
import com.example.theatre.core.data.model.PerformancePlace
import com.example.theatre.core.data.model.PerformancePlaceLocation
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.databinding.FragmentReviewBinding
import com.example.theatre.core.presentation.utils.DateUtils.convertIntToStringBuilder
import com.example.theatre.core.presentation.utils.Default.orDefault
import com.example.theatre.features.info.presentation.ui.detail.toRole
import com.example.theatre.features.spectacles.presentation.ui.detail.EventFragment.Companion.event_id
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Фрагмент с отображением деталей места постановки
 *
 * @author Marianna Sabanchieva
 */

class ReviewFragment : Fragment() {

    companion object {
        fun newInstance(): ReviewFragment {
            return ReviewFragment()
        }
    }

    private lateinit var binding: FragmentReviewBinding
    private val spectacleViewModel by sharedViewModel<SpectacleDetailsViewModel>()
    private lateinit var cityName: String
    private lateinit var gaps: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
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
                textAgeRestriction.text = age_restriction
                val datesList = StringBuilder()
                for (i in 0 until dates.size) {
                    datesList.appendLine(convertIntToStringBuilder(dates[i].start.orDefault(), dates[i].end.orDefault()))
                }
                textEventStartEnd.text = datesList
                val participantsList = StringBuilder()
                for (i in 0 until participants.size) {
                    val role = getString(participants[i].role?.slug.orEmpty().toRole())
                    val partList = participants[i].agent_model?.title.orEmpty()
                    participantsList.appendLine("${partList}$gaps$role")
                }
                textParticipantsList.text = participantsList
            }
        }
    }

    private fun setCity(city: PerformancePlaceLocation) {
        cityName = city.name.toString()
    }

    private fun setPlace(place: PerformancePlace) {
        with(binding) {
            with(place) {
                textPlaceTitle.text = try { title.orEmpty().replaceFirstChar { it.uppercaseChar() } } catch (e: NumberFormatException) { null }
                textPlaceSubway.text = subway
                ((cityName + gaps).plus(address)).also {
                    textPlaceAddress.text = it
                }
                (getString(R.string.tel).plus(phone)).also {
                    textPlacePhone.text = it
                }
                (getString(R.string.website).plus(foreign_url.orEmpty())).also {
                    textPlaceSite.text = it
                }
                if (is_closed == true) {
                    textPlaceIsclosed.text = getString(R.string.place_is_closed)
                }
            }
        }
    }
}
