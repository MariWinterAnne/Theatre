package com.example.theatre.features.spectacles.presentation.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.theatre.R
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.databinding.FragmentSpectaclesBinding
import com.example.theatre.features.spectacles.presentation.adapters.EventListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Фрагмент со списком постановок
 *
 * @author Marianna Sabanchieva
 */

class SpectaclesFragment : Fragment() {

    private lateinit var binding: FragmentSpectaclesBinding
    private lateinit var performancesAdapter: EventListAdapter
    private lateinit var recyclerView: RecyclerView
    private val spectacleViewModel by viewModel<SpectacleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_spectacles, container, false)

        recyclerView = view.findViewById(R.id.list_event) as RecyclerView
        performancesAdapter = EventListAdapter(mutableListOf()) { id ->
            onSpectacleClick(id)
        }
        recyclerView.adapter = performancesAdapter

        initObservers()
        spectacleViewModel.init()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSpectaclesBinding.bind(view)
    }

    private fun initObservers() {
        spectacleViewModel.spectacleLoaded.observe(viewLifecycleOwner, ::setSpectacles)
    }

    private fun setSpectacles(performances: List<Performance>) {
        performancesAdapter.setSpectacles(performances)
    }

    private fun onSpectacleClick(id: Int) {
        val bundle = bundleOf("id" to id)
        requireActivity().findNavController(R.id.navHostFragment)
            .navigate(R.id.action_performance_to_eventFragment, bundle)
    }
}
