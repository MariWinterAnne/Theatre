package com.example.theatre.features.spectacles.presentation.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.theatre.R
import com.example.theatre.core.domain.models.Performance
import com.example.theatre.core.domain.models.PerformancePlaceLocation
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.core.presentation.model.handleContents
import com.example.theatre.core.utils.StringUtils.EMPTY
import com.example.theatre.databinding.FragmentEventBinding
import com.example.theatre.features.spectacles.presentation.adapters.SectionPagerAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Фрагмент с отображением деталей события
 *
 * @author Marianna Sabanchieva
 */

class SpectacleDetailsFragment : Fragment() {

    companion object {
        const val event_id = "id"
    }

    lateinit var binding: FragmentEventBinding
    private val spectacleViewModel by sharedViewModel<SpectacleDetailsViewModel>()
    private var eventURL: String? = null

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
        viewPager.adapter = SectionPagerAdapter(requireActivity().supportFragmentManager)

        val tabLayout = binding.content.tabs
        tabLayout.setupWithViewPager(viewPager)

        arguments?.run { spectacleViewModel.init(getInt(event_id)) }
        spectacleViewModel.spectacleDetailLoaded.observe(viewLifecycleOwner, ::handleInfo)
        spectacleViewModel.cityLoaded.observe(viewLifecycleOwner, ::handleInfo)
    }

    private fun handleInfo(contentResultState: ContentResultState) {
        contentResultState.handleContents(
            onStateSuccess = {
                when (it) {
                    is Performance -> {
                        setDetails(it)
                    }
                    is PerformancePlaceLocation -> {
                        setCity(it)
                    }
                }
            },
            onStateError = {

            }
        )
    }

    private fun setDetails(eventDetails: Performance) {
        eventURL = eventDetails.siteUrl
        with(binding.content) {
            with(eventDetails) {
                textName.text = shortTitle.orEmpty().replaceFirstChar { it.uppercaseChar() }
                if (isFree == true) {
                    textPrice.text = context?.getString(R.string.free)
                } else {
                    textPrice.text = price
                }
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
            }
        }
    }

    private fun setCity(city: PerformancePlaceLocation) {
        binding.content.textVenue.text = city.name
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_event, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            android.R.id.home -> requireActivity().onBackPressed()
            R.id.action_event -> {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(eventURL))
                startActivity(browserIntent)
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }
}
