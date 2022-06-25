package com.example.theatre.features.spectacles.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.theatre.R
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.core.presentation.utils.deleteHTML
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
                try{
                    val img = images.first().image.toString()
                    context?.let {
                        Glide
                            .with(it)
                            .load(img)
                            .into(imageThumbnail)
                    }
                } catch (e: NumberFormatException) { root.context.getString(R.string.empty) }
                try{ textName.text = title.replaceFirstChar { it.uppercaseChar() } } catch (e: NumberFormatException) { root.context.getString(R.string.empty) }
                textDescription.text = (description.orEmpty()).deleteHTML()
                textTagline.text = tagline
                textBody.text = (body_text.orEmpty()).deleteHTML()
            }
        }
    }
}
