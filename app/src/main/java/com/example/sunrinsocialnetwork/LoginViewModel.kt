package com.example.sunrinsocialnetwork

import android.util.Log
import androidx.fragment.app.FragmentManager.TAG
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunrinsocialnetwork.UtilCode.ACCESS_TOKEN
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepositoryImpl) : ViewModel() {
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _isSuccess = MutableLiveData<Boolean>()
    val isSuccess: LiveData<Boolean>
        get() = _isSuccess
    private val _refreshToken = MutableLiveData<String>()
    val refreshToken: LiveData<String>
        get() = _refreshToken

    fun login() {
        viewModelScope.launch {
            val result = repository.login(email.value!!, password.value!!)
            if(result.isSuccessful) {
                _isSuccess.value = true
                Log.d(TAG, "login Access Token: ${result.body()!!.access}")
                ACCESS_TOKEN = result.body()!!.access
            }else {
                _isSuccess.value = false
            }
        }

    }
}