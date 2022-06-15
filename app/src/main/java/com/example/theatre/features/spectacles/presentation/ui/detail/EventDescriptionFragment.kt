package com.example.theatre.features.spectacles.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.theatre.R
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.core.presentation.utils.HtmlUtils.deleteHTML
import com.example.theatre.databinding.FragmentEventDescriptionBinding
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Фрагмент с подробным описанием события
 *
 * @author Marianna Sabanchieva
 */

class EventDescriptionFragment : Fragment() {

    companion object {
        private const val event_id = "id"
        fun newInstance(): EventDescriptionFragment {
            return EventDescriptionFragment()
        }
    }

    private lateinit var binding: FragmentEventDescriptionBinding
    private val spectacleViewModel by viewModel<SpectacleDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_event_description, container, false)

        arguments?.run { spectacleViewModel.init(getInt(event_id)) }
        spectacleViewModel.spectacleDetailLoaded.observe(viewLifecycleOwner, ::setDetails)

        return binding.root
    }

    private fun setDetails(eventDetails: Performance){
        with(binding) {
            with(eventDetails) {
                Picasso.get()
                    .load(images.first().image.toString())
                    .into(imageThumbnail)
                textName.text = title.orEmpty().replaceFirstChar { it.uppercaseChar() }
                textDescription.text = deleteHTML(description.orEmpty())
                textTagline.text = tagline
                textBody.text = deleteHTML(body_text.orEmpty())
            }
        }
    }
}
