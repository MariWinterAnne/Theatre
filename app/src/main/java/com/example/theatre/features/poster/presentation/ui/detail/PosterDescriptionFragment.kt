package com.example.theatre.features.poster.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.theatre.core.presentation.ext.EMPTY
import com.example.theatre.core.presentation.ext.deleteHTML
import com.example.theatre.databinding.FragmentPosterDescriptionBinding
import com.example.theatre.features.poster.domain.model.PosterDetails
import com.example.theatre.features.poster.presentation.ui.detail.PosterDetailFragment.Companion.poster_id
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Фрагмент описания афиши
 * @author Tamerlan Mamukhov on 2022-05-28
 */
class PosterDescriptionFragment : Fragment() {
    private lateinit var binding: FragmentPosterDescriptionBinding
    private val viewModel by sharedViewModel<PosterDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPosterDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.run { viewModel.getPoster(getInt(poster_id)) }

//        viewModel.posterDetailedLoaded.observe(viewLifecycleOwner, ::setDetails)
    }

    private fun setDetails(posterDetails: PosterDetails) =
        with(binding) {
            with(posterDetails) {

                val imageURL =
                    if (this.images?.isNotEmpty() == true) images.first().imageURL.orEmpty() else String.EMPTY
                if (imageURL.isNotEmpty()) {
                    context?.let {
                        Glide
                            .with(it)
                            .load(imageURL)
                            .into(imageThumbnail)
                    }

                }

                textName.text = title.replaceFirstChar { it.uppercaseChar() }
                textDescription.text = description.orEmpty().deleteHTML()
                textTagline.text = tagline
                textBody.text = bodyText.orEmpty().deleteHTML()

            }
        }
}