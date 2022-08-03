package com.example.theatre.features.poster.presentation.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.theatre.databinding.FragmentPosterBinding
import com.example.theatre.features.poster.domain.model.PosterBriefItem
import com.example.theatre.features.poster.presentation.adapters.PosterBriefItemAdapter
import org.intellij.lang.annotations.JdkConstants
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Фрагмент со списком афиш
 *
 * @author Tamerlan Mamukhov on 2022-05-28
 */
class PosterFragment : Fragment() {

    private lateinit var adapter: PosterBriefItemAdapter
    private lateinit var binding: FragmentPosterBinding
    private val viewModel by viewModel<PostersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPosterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.postersList.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        adapter = PosterBriefItemAdapter(mutableListOf()) {

        }
        binding.postersList.adapter = adapter

        initObservers()

        viewModel.init()
    }

    private fun initObservers() {
        viewModel.postersBrief.observe(viewLifecycleOwner, ::setData)
    }

    private fun setData(list: List<PosterBriefItem>) {
        adapter.setData(list)
        Log.d("DATA!!!", "setData: $list")
    }

}