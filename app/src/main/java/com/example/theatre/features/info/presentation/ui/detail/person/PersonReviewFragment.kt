package com.example.theatre.features.info.presentation.ui.detail.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import com.example.theatre.R
import com.example.theatre.databinding.FragmentReviewBinding
import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.presentation.ui.utils.toListOfPerformances
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Фрагмент с отображением подробностей об актере
 *
 * @author Marianna Sabanchieva
 */

class PersonReviewFragment : Fragment() {

    companion object {
        const val DETAILS_TAB = 1
        const val DETAILS = "Детали"
        const val person_id = "id"
        fun newInstance(): PersonReviewFragment {
            return PersonReviewFragment()
        }
    }

    private lateinit var binding: FragmentReviewBinding
    private val personViewModel by sharedViewModel<PersonDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.fragment_review, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentReviewBinding.bind(view)
        arguments?.run { personViewModel.getPersonById(getInt(person_id)) }
        personViewModel.personDetails.observe(viewLifecycleOwner, ::setDetails)
    }

    private fun setDetails(personDetails: Agent) {
        with(binding) {
            textDatetime.text = getString(R.string.person_participations)
            textPlaceTitle.isInvisible = true
            textPlaceSubway.isInvisible = true
            textPlaceAddress.isInvisible = true
            textPlacePhone.isInvisible = true
            textPlaceSite.isInvisible = true
            with(personDetails) {
                textEventStartEnd.text = participations?.toListOfPerformances(requireContext())
            }
        }
    }
}
