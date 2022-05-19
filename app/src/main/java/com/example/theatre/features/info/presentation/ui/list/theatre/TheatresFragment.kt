package com.example.theatre.features.info.presentation.ui.list.theatre

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.theatre.R
import com.example.theatre.databinding.FragmentTheatresBinding
import com.example.theatre.features.info.domain.model.Theatre
import com.example.theatre.features.info.presentation.adapters.TheatresListAdapter
import com.example.theatre.features.info.presentation.ui.detail.theatre.TheatreActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class TheatresFragment : Fragment() {

    companion object {
        fun newInstance(): TheatresFragment {
            return TheatresFragment()
        }
    }

    private lateinit var binding: FragmentTheatresBinding
    private lateinit var theatresAdapter: TheatresListAdapter
    private lateinit var recyclerView: RecyclerView
    private val theatreViewModel by viewModel<TheatreViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_theatres, container, false)

        recyclerView = view.findViewById(R.id.list_theatre) as RecyclerView
        theatresAdapter = TheatresListAdapter(mutableListOf()) { id ->
            onTheatreClick(id)
        }
        recyclerView.adapter = theatresAdapter
        initObservers()

        lifecycleScope.launchWhenCreated {
            theatreViewModel.init()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTheatresBinding.bind(view)
    }

    private fun initObservers() {
        theatreViewModel.theatreLoaded.observe(viewLifecycleOwner, ::setTheatres)
    }

    private fun setTheatres(theatres: List<Theatre>) {
        theatresAdapter.setTheatres(theatres)
    }

    private fun onTheatreClick(id: Int) {
        val intent = Intent(activity, TheatreActivity::class.java)
        intent.putExtra("theatre_id", id)
        startActivity(intent)
    }

}