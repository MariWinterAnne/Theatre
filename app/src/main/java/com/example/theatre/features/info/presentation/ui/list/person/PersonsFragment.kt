package com.example.theatre.features.info.presentation.ui.list.person

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.theatre.R
import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.presentation.adapters.PersonsListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Фрагмент со списком актеров
 *
 * @author Marianna Sabanchieva
 */

class PersonsFragment : Fragment() {

    companion object {
        const val DETAILS_TAB = 1
        const val PERSON = "Персона"
        fun newInstance(): PersonsFragment {
            return PersonsFragment()
        }
    }

    private lateinit var personsAdapter: PersonsListAdapter
    private lateinit var recyclerView: RecyclerView
    private val personsViewModel by viewModel<PersonViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_persons, container, false)

        recyclerView = view.findViewById(R.id.list_persons) as RecyclerView
        personsAdapter = PersonsListAdapter(mutableListOf()) { id ->
            onPersonClick(id)
        }
        recyclerView.adapter = personsAdapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        personsViewModel.init()
    }

    private fun initObservers() {
        personsViewModel.personLoaded.observe(viewLifecycleOwner, ::setPersons)
    }

    private fun setPersons(persons: List<Agent>) {
        personsAdapter.setPersons(persons)
    }

    private fun onPersonClick(id: Int) {
        val bundle = bundleOf("id" to id)
        requireActivity().findNavController(R.id.navHostFragment)
            .navigate(R.id.action_info_to_personFragment, bundle)
    }
}