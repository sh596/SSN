package com.example.sunrinsocialnetwork

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.sunrinsocialnetwork.base.BaseFragment
import com.example.sunrinsocialnetwork.databinding.FragmentSignUp1Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment1 : BaseFragment<FragmentSignUp1Binding>(R.layout.fragment_sign_up_1) {
    private val viewModel : SignUpViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

    }

    fun observeNickname(s: CharSequence, start :Int, before : Int,count: Int) {
        viewModel.nickname.observe(requireActivity(), Observer {
            viewModel.confirmNickname()
        })
    }
    fun nextFragment(view: View) {
        if(viewModel.nickname.value== null){
            binding.textSignUpFragmentNicknameConfirmText.setTextColor(Color.parseColor("#ED1B1B"))
            return
        }
        if(viewModel.isConfirmOfNickName.value == true) {
            Navigation.findNavController(binding.root).navigate(R.id.action_signUpFragment1_to_signUpFragment2)
        }
    }

}