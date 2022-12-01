package com.example.sunrinsocialnetwork

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.dudeulimproject.base.BaseActivity
import com.example.sunrinsocialnetwork.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.activity =this
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.isSuccess.observe(this, Observer {
            if(it){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
            }
        })

    }


    fun clickSignUpButton(view :View){
        startActivity(Intent(this, SignUpActivity::class.java))
    }
    fun clickSignInButton(view :View){
        viewModel.login()

    }
}