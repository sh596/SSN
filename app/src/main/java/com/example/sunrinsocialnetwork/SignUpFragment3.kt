package com.example.sunrinsocialnetwork

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.sunrinsocialnetwork.base.BaseFragment
import com.example.sunrinsocialnetwork.databinding.FragmentSignUp3Binding


class SignUpFragment3 : BaseFragment<FragmentSignUp3Binding>(R.layout.fragment_sign_up_3) {
    private val viewModel : SignUpViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.isSuccess.observe(requireActivity(), Observer {
            if(it){
                activity?.finish()
            }
        })
    }

    fun observePassword(s: CharSequence, start :Int, before : Int, count: Int) {
        viewModel.password.observe(requireActivity(), Observer {
            viewModel.confirmPassword1()
        })
    }

    fun observeConfirmPassword(s: CharSequence, start :Int, before : Int, count: Int) {
        viewModel.confirmPassword.observe(requireActivity(), Observer {
            viewModel.confirmPassword2()
        })
    }
    fun nextButton(view: View) {
        if(viewModel.email.value == null){
            binding.textSignUpFragmentPasswordConfirmText.setTextColor(Color.parseColor("#ED1B1B"))
            binding.textSignUpFragmentConfirmPasswordConfirmText.visibility = View.VISIBLE
            return
        }
        if(viewModel.isConfirmOfPassword2.value == true) {
            viewModel.signUp()
        }
    }
}