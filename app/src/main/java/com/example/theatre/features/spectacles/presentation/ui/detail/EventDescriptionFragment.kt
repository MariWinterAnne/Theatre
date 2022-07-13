package com.example.theatre.features.spectacles.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.theatre.R
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.core.utils.StringUtils.Companion.EMPTY
import com.example.theatre.core.utils.StringUtils.Companion.deleteHTML
import com.example.theatre.databinding.FragmentEventDescriptionBinding
import com.example.theatre.features.spectacles.presentation.ui.detail.EventFragment.Companion.event_id
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Фрагмент с подробным описанием события
 *
 * @author Marianna Sabanchieva
 */

class EventDescriptionFragment : Fragment() {

    companion object {
        const val DESCRIPTION_TAB = 0
        const val INFO = "Информация"
        fun newInstance(): EventDescriptionFragment {
            return EventDescriptionFragment()
        }
    }

    private lateinit var binding: FragmentEventDescriptionBinding
    private val spectacleViewModel by sharedViewModel<SpectacleDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentEventDescriptionBinding.bind(view)
        arguments?.run { spectacleViewModel.init(getInt(event_id)) }
        spectacleViewModel.spectacleDetailLoaded.observe(viewLifecycleOwner, ::setDetails)
    }

    private fun setDetails(eventDetails: Performance) {
        with(binding) {
            with(eventDetails) {
                val imageURL = if (images.isNotEmpty()) images.first().image.orEmpty() else String.EMPTY
                if (imageURL.isNotEmpty()) {
                    context?.let {
                        Glide
                            .with(it)
                            .load(imageURL)
                            .into(imageThumbnail)
                    }
                }
                textName.text = title.replaceFirstChar { it.uppercaseChar() }
                textDescription.text = (description.orEmpty()).deleteHTML()
                textTagline.text = tagline
                textBody.text = (body_text.orEmpty()).deleteHTML()
            }
        }
    }
}
