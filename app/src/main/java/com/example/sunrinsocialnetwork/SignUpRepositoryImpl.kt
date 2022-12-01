package com.example.sunrinsocialnetwork

import com.example.sunrinsocialnetwork.data.SignUpRequest
import com.example.sunrinsocialnetwork.data.SignUpResponse
import com.example.sunrinsocialnetwork.data.remote.MainService
import retrofit2.Response
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(private val service : MainService) : SignUpRepository{
    override suspend fun signUp(email : String, password: String, nickname: String): Response<SignUpResponse> {
        return service.signUp(SignUpRequest(email, password, nickname))
    }
}