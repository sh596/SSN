package com.example.sunrinsocialnetwork

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.sunrinsocialnetwork.base.BaseFragment
import com.example.sunrinsocialnetwork.databinding.FragmentSignUp2Binding

class SignUpFragment2 : BaseFragment<FragmentSignUp2Binding>(R.layout.fragment_sign_up_2) {
    private val viewModel : SignUpViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.email.observe(requireActivity(), Observer {
            viewModel.confirmEmail()
        })
        binding.textSignUpFragmentEmailConfirmText.visibility = View.INVISIBLE
    }


    fun nextFragment(view: View) {
        if(viewModel.email.value == null){
            binding.textSignUpFragmentEmailConfirmText.visibility = View.VISIBLE
            return
        }
        if(viewModel.isConfirmOfEmail.value == true) {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_signUpFragment2_to_signUpFragment3)
        }
    }
}