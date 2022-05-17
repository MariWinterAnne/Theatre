package com.example.theatre.features.info.presentation.ui.list.person

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.theatre.R
import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.presentation.adapters.PersonsListAdapter
import com.example.theatre.features.info.presentation.ui.detail.person.PersonActivity


import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonsFragment : Fragment() {

    companion object {
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
        initObservers()

        lifecycleScope.launchWhenCreated {
            personsViewModel.init()
        }

        return view
    }

    private fun initObservers() {
        personsViewModel.personLoaded.observe(viewLifecycleOwner, ::setPersons)
    }

    private fun setPersons(persons: List<Agent>) {
        personsAdapter.setPersons(persons)
    }

    private fun onPersonClick(id: Int) {
        val intent = Intent(activity, PersonActivity::class.java)
        intent.putExtra("person_id", id)
        startActivity(intent)
    }

}