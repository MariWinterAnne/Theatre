package com.example.theatre.features.info.presentation.ui.list.theatre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.theatre.R
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.core.presentation.model.handleContents
import com.example.theatre.core.presentation.ui.LayoutErrorHandler
import com.example.theatre.databinding.FragmentTheatresBinding
import com.example.theatre.features.info.domain.model.Theatre
import com.example.theatre.features.info.presentation.adapters.TheatresListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Фрагмент со списком театров
 *
 * @author Marianna Sabanchieva
 */

class TheatresListFragment : Fragment() {

    companion object {
        const val DESCRIPTION_TAB = 0
        const val THEATRE = "Театр"
        fun newInstance(): TheatresListFragment {
            return TheatresListFragment()
        }
    }

    private lateinit var binding: FragmentTheatresBinding
    private lateinit var theatresAdapter: TheatresListAdapter
    private lateinit var recyclerView: RecyclerView
    private val theatresListViewModel by viewModel<TheatresListViewModel>()

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
        theatresListViewModel.getTheatres()
    }

    private fun initObservers() {
        theatresListViewModel.theatresContent.observe(viewLifecycleOwner, ::handleTheatres)
    }

    private fun handleTheatres(contentResultState: ContentResultState) =
        contentResultState.handleContents(
            onStateSuccess = {
                theatresAdapter.setTheatres(it as List<Theatre>)
                binding.listTheatre.adapter = theatresAdapter
            },
            onStateError = {
                with(binding) {
                    LayoutErrorHandler(
                        this?.errorLayout!!,
                        { tryAgain() },
                        it,
                        this.listTheatre
                    )
                }
            }
        )

    private fun tryAgain() {
        binding?.errorLayout?.root?.visibility = View.INVISIBLE
        theatresListViewModel.getTheatres()
        initObservers()
    }

    private fun onTheatreClick(id: Int) {
        val bundle = bundleOf("id" to id)
        requireActivity().findNavController(R.id.navHostFragment)
            .navigate(R.id.action_info_to_theatreFragment, bundle)
    }
}