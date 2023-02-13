package com.example.theatre.features.info.presentation.ui.detail.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.theatre.R
import com.example.theatre.core.presentation.ext.EMPTY
import com.example.theatre.core.presentation.ext.deleteHTML
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.core.presentation.model.handleContents
import com.example.theatre.databinding.FragmentEventDescriptionBinding
import com.example.theatre.core.domain.model.common.agent.Agent
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Фрагмент с подробностями об актере
 *
 * @author Tamerlan Mamukhov
 */

class PersonDescriptionFragment : Fragment() {

    companion object {
        const val DESCRIPTION_TAB = 0
        const val INFO = "Информация"
        const val person_id = "id"
        fun newInstance(): PersonDescriptionFragment {
            return PersonDescriptionFragment()
        }
    }

    private lateinit var binding: FragmentEventDescriptionBinding
    private val personViewModel by sharedViewModel<PersonDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.fragment_event_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentEventDescriptionBinding.bind(view)
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
            with(personDetails) {
                val imageURL =
                    if (images?.isNotEmpty() == true) images.first().imageURL.orEmpty() else String.EMPTY
                if (imageURL.isNotEmpty()) {
                    context?.let {
                        Glide
                            .with(it)
                            .load(imageURL)
                            .into(imageThumbnail)
                    }
                }
                textName.text = title
                textDescription.text = description.orEmpty().deleteHTML().trimEnd()
                textBody.text = bodyText.orEmpty().deleteHTML().trimEnd()
                textTagline.visibility = View.GONE
            }
        }
    }
}
