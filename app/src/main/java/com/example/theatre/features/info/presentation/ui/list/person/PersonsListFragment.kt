package com.example.theatre.features.info.presentation.ui.list.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.theatre.R
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.core.presentation.model.handleContents
import com.example.theatre.core.presentation.ui.LayoutErrorHandler
import com.example.theatre.databinding.FragmentPersonsBinding
import com.example.theatre.core.domain.model.common.agent.Agent
import com.example.theatre.core.presentation.model.refreshPage
import com.example.theatre.features.info.presentation.adapters.PersonsListAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Фрагмент со списком актеров
 *
 * @author Tamerlan Mamukhov
 */

class PersonsListFragment : Fragment() {

    companion object {
        const val DETAILS_TAB = 1
        const val PERSON = "Персона"
        fun newInstance(): PersonsListFragment {
            return PersonsListFragment()
        }
    }

    private lateinit var binding: FragmentPersonsBinding
    private lateinit var personsAdapter: PersonsListAdapter
    private val personsViewModel by viewModel<PersonsListViewModel>()
    private val layoutErrorHandler by inject<LayoutErrorHandler>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentPersonsBinding.inflate(inflater, container, false)

        personsAdapter = PersonsListAdapter(
            mutableListOf()
        ) {
            onPersonClick(it)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        personsViewModel.init()
    }

    private fun initObservers() =
        personsViewModel.personLoaded.observe(viewLifecycleOwner, ::handlePersons)


    private fun handlePersons(contentResultState: ContentResultState) {
        contentResultState.refreshPage(binding?.listPersons!!, binding?.progressBar4!!)
        contentResultState.handleContents(
            onStateSuccess = {
                personsAdapter.setPersons(it as List<Agent>)
                binding.listPersons.adapter = personsAdapter
            },
            onStateError = {
                with(binding) {
                    layoutErrorHandler.handleLayout(
                        this?.errorLayout!!,
                        { tryAgain() },
                        it,
                        this.listPersons
                    )
                }
            }
        )
    }
    private fun tryAgain() {
        binding?.errorLayout?.root?.visibility = View.INVISIBLE
        personsViewModel.init()
        initObservers()
    }

    private fun onPersonClick(id: Int) {
        val bundle = bundleOf("id" to id)
        requireActivity().findNavController(R.id.navHostFragment)
            .navigate(R.id.action_info_to_personFragment, bundle)
    }
}