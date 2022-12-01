package com.example.sunrinsocialnetwork

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.sunrinsocialnetwork.base.BaseFragment
import com.example.sunrinsocialnetwork.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment :BaseFragment<FragmentMainBinding>(R.layout.fragment_main){
    private val viewModel : MainFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel= viewModel
        binding.lifecycleOwner = this
        val adapter = MainFragmentAdapter()
        binding.recyclerMainFragmentBoard.adapter = adapter
        viewModel.getBoard()
        viewModel.getMealData()

        viewModel.boardList.observe(requireActivity() , Observer {
            adapter.submitList(it)
        })
    }

}