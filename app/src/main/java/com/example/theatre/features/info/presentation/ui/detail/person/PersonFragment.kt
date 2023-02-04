package com.example.theatre.features.info.presentation.ui.detail.person

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
import com.example.theatre.core.presentation.model.handleContents
import com.example.theatre.databinding.FragmentEventBinding
import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.presentation.adapters.PersonPagerAdapter
import com.example.theatre.features.info.presentation.ui.detail.toAgent
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Фрагмент с отображением детальной информации об актере
 *
 * @author Marianna Sabanchieva
 */

class PersonFragment : Fragment() {

    companion object {
        const val person_id = "id"
    }

    lateinit var binding: FragmentEventBinding
    private val personViewModel by sharedViewModel<PersonDetailViewModel>()

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
        viewPager.adapter = PersonPagerAdapter(requireActivity().supportFragmentManager)

        val tabLayout = binding.content.tabs
        tabLayout.setupWithViewPager(viewPager)

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
        with(binding.content) {
            with(personDetails) {
                textPrice.text = getString(agentType.orEmpty().toAgent())
                textName.text = title.replaceFirstChar { it.uppercaseChar() }
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

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            android.R.id.home -> requireActivity().findNavController(R.id.navHostFragment).popBackStack()
        }
        return super.onOptionsItemSelected(menuItem)
    }
}
