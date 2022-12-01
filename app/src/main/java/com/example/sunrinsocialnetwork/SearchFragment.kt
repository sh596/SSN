package com.example.sunrinsocialnetwork

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentManager.TAG
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.sunrinsocialnetwork.base.BaseFragment
import com.example.sunrinsocialnetwork.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment :BaseFragment<FragmentSearchBinding>(R.layout.fragment_search){
    private val viewModel : SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel= viewModel
        binding.fragment = this
        binding.lifecycleOwner = this
        val adapter = MainFragmentAdapter()
        binding.recyclerSearchFragment.adapter = adapter

        viewModel.boardList.observe(requireActivity() , Observer {
            adapter.submitList(it)
        })
    }
    fun clickSearchButton(view : View) {

        viewModel.search()
    }
}