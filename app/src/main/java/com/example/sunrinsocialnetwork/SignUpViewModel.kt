package com.example.sunrinsocialnetwork

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunrinsocialnetwork.data.SignUpResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val repository : SignUpRepositoryImpl): ViewModel() {
    val nickname = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val confirmPassword = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    private val _isConfirmOfNickName = MutableLiveData<Boolean>(true)
    val isConfirmOfNickName : LiveData<Boolean>
        get() = _isConfirmOfNickName
    private val _isConfirmOfEmail = MutableLiveData<Boolean>(true)
    val isConfirmOfEmail : LiveData<Boolean>
        get() = _isConfirmOfEmail
    private val _isSuccess = MutableLiveData(false)
    val isSuccess : LiveData<Boolean>
        get() = _isSuccess

    private val _isConfirmOfPassword1 = MutableLiveData<Boolean>(true)
    val isConfirmOfPassword1 : LiveData<Boolean>
        get() = _isConfirmOfPassword1

    private val _isConfirmOfPassword2 = MutableLiveData<Boolean>(true)
    val isConfirmOfPassword2 : LiveData<Boolean>
        get() = _isConfirmOfPassword2

    fun confirmPassword1(){
        _isConfirmOfPassword1.value = password.value!!.length in 3..20
    }

    fun confirmPassword2(){
        if(_isConfirmOfPassword1.value == true){
            _isConfirmOfPassword2.value = confirmPassword.value == password.value
        }
    }

    fun confirmNickname(){
        _isConfirmOfNickName.value = nickname.value!!.length in 3..20
    }
    fun confirmEmail() {
        if (email.value != null) {
            val regex = "^\\d{2}sunrin\\d{3}@sunrint.hs.kr\$"
            _isConfirmOfEmail.value = Pattern.matches(regex, email.value!!.trim())
        }
    }

     fun signUp() {
        viewModelScope.launch {
            val result = repository.signUp(email.value!!, password.value!!, nickname.value!!)
            if(result.isSuccessful) {
                _isSuccess.value = true
            }
        }
    }

}
