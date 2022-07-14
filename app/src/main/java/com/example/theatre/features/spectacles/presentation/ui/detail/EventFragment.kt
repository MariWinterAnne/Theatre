package com.example.theatre.features.spectacles.presentation.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.MenuItem
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.theatre.R
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.core.domain.model.PerformancePlaceLocation
import com.example.theatre.core.utils.StringUtils.EMPTY
import com.example.theatre.databinding.FragmentEventBinding
import com.example.theatre.features.spectacles.presentation.adapters.SectionPagerAdapter
import com.example.theatre.network.Constants.ISFREE
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Фрагмент с отображением деталей события
 *
 * @author Marianna Sabanchieva
 */

class EventFragment : Fragment() {

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
        spectacleViewModel.spectacleDetailLoaded.observe(viewLifecycleOwner, ::setDetails)
        spectacleViewModel.cityLoaded.observe(viewLifecycleOwner, ::setCity)
    }

    private fun setDetails(eventDetails: Performance) {
        eventURL = eventDetails.site_url
        with(binding.content) {
            with(eventDetails) {
                textName.text = short_title.orEmpty().replaceFirstChar { it.uppercaseChar() }
                if (is_free == true) {
                    textPrice.text = ISFREE
                } else {
                    textPrice.text = price
                }
                val imageURL = if (images.isNotEmpty()) images.first().image.orEmpty() else String.EMPTY
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
