package com.example.theatre.features.info.presentation.ui.detail.theatre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.theatre.R
import com.example.theatre.core.presentation.ext.EMPTY
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.databinding.FragmentEventBinding
import com.example.theatre.features.info.domain.model.Theatre
import com.example.theatre.features.info.domain.model.TheatreLocation
import com.example.theatre.features.info.presentation.adapters.TheatrePagerAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Фрагмент с отображением детальной информации о театре
 *
 * @author Marianna Sabanchieva
 */

class TheatreFragment : Fragment() {

    companion object {
        const val theatre_id = "id"
    }

    lateinit var binding: FragmentEventBinding
    private val theatreViewModel by sharedViewModel<TheatreDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        setHasOptionsMenu(true)
        requireActivity().actionBar?.setDisplayHomeAsUpEnabled(true)
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentEventBinding.bind(view)

        val viewPager = binding.content.viewPager
        viewPager.adapter = TheatrePagerAdapter(requireActivity().supportFragmentManager)

        val tabLayout = binding.content.tabs
        tabLayout.setupWithViewPager(viewPager)

        arguments?.run { theatreViewModel.getTheatreById(getInt(theatre_id)) }

        theatreViewModel.theatreDetailsContent.observe(viewLifecycleOwner, ::handleContent)
        theatreViewModel.cityContent.observe(viewLifecycleOwner, ::handleContent)
    }

    private fun handleContent(contentResultState: ContentResultState) = when (contentResultState) {
        is ContentResultState.Content -> {
            contentResultState.handle()
        }
        is ContentResultState.Error -> {
            contentResultState.handle()
        }
        else -> {}
    }


    private fun ContentResultState.Content.handle() = when (content) {
        is Theatre -> setDetails(content)
//        is TheatreLocation -> setCity(content)
        else -> {}
    }

    private fun ContentResultState.Error.handle() {
    }

    private fun setDetails(theatreDetails: Theatre) {
        with(binding.content) {
            with(theatreDetails) {
                textName.text = shortTitle.orEmpty().replaceFirstChar { it.uppercaseChar() }
                val imageURL =
                    if (images?.isNotEmpty() == true) images.first().imageURL.orEmpty() else String.EMPTY
                if (imageURL.isNotEmpty()) {
                    context?.let {
                        Glide
                            .with(it)
                            .load(imageURL)
                            .into(imageThumbnail)

                        Glide
                            .with(it)
                            .load(imageURL)
                            .into(binding.imageLarge)
                    }
                }
                textVenue.text = subway
            }
        }
    }

    private fun setCity(city: TheatreLocation) {
        binding.content.textPrice.text = city.name
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            android.R.id.home -> requireActivity().findNavController(R.id.navHostFragment)
                .popBackStack()
        }
        return super.onOptionsItemSelected(menuItem)
    }
}
