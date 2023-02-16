package com.example.theatre.features.info.presentation.ui.detail.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.theatre.R
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.core.presentation.model.handleContents
import com.example.theatre.databinding.FragmentReviewBinding
import com.example.theatre.core.domain.model.common.agent.Agent
import com.example.theatre.core.presentation.ext.toListOfPerformances
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Фрагмент с отображением подробностей об актере
 *
 * @author Tamerlan Mamukhov
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
        personViewModel.personDetails.observe(viewLifecycleOwner, ::handleInfo)
    }

    private fun handleInfo(contentResultState: ContentResultState) {
        contentResultState.handleContents(
            onStateSuccess = {
                setDetails(it as Agent)
            },
            onStateError = {
                // TODO: Добавить обработку ошибки (например сообщение)
            }
        )
    }

    private fun setDetails(personDetails: Agent) {
        with(binding) {
            textDatetime.text = getString(R.string.person_participations)
            textPlaceTitle.visibility = View.GONE
            textPlaceSubway.visibility = View.GONE
            textPlaceAddress.visibility = View.GONE
            textPlacePhone.visibility = View.GONE
            textPlaceSite.visibility = View.GONE
            with(personDetails) {
                textEventStartEnd.text = participations?.toListOfPerformances(requireContext())
            }
        }
    }
}
