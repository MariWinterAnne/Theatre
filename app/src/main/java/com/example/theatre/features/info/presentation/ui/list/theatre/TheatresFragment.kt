package com.example.theatre.features.info.presentation.ui.list.theatre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.theatre.R
import com.example.theatre.core.presentation.model.handleContents
import com.example.theatre.databinding.FragmentTheatresBinding
import com.example.theatre.features.info.domain.model.Theatre
import com.example.theatre.features.info.presentation.adapters.TheatresListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Фрагмент со списком театров
 *
 * @author Marianna Sabanchieva
 */

class TheatresFragment : Fragment() {

    companion object {
        const val DESCRIPTION_TAB = 0
        const val THEATRE = "Театр"
        fun newInstance(): TheatresFragment {
            return TheatresFragment()
        }
    }

    private lateinit var binding: FragmentTheatresBinding
    private lateinit var theatresAdapter: TheatresListAdapter
    private lateinit var recyclerView: RecyclerView
    private val theatreViewModel by viewModel<TheatreViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_theatres, container, false)

        recyclerView = view.findViewById(R.id.list_theatre) as RecyclerView
        theatresAdapter = TheatresListAdapter(mutableListOf()) { id ->
            onTheatreClick(id)
        }
        recyclerView.adapter = theatresAdapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTheatresBinding.bind(view)

        initObservers()
        theatreViewModel.getTheatres()
    }

    private fun initObservers() {
        theatreViewModel.theatresContent.observe(viewLifecycleOwner) {
            it?.handleContents(
                { theatresAdapter.setTheatres(it as List<Theatre>) },
                { Toast.makeText(activity, "No internet!", Toast.LENGTH_SHORT).show() }
            )
        }
    }

    private fun onTheatreClick(id: Int) {
        val bundle = bundleOf("id" to id)
        requireActivity().findNavController(R.id.navHostFragment)
            .navigate(R.id.action_info_to_theatreFragment, bundle)
    }
}