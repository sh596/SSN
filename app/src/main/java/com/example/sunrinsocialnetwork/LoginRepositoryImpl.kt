package com.example.sunrinsocialnetwork

import com.example.sunrinsocialnetwork.data.LoginRequest
import com.example.sunrinsocialnetwork.data.LoginResponse
import com.example.sunrinsocialnetwork.data.remote.MainService
import retrofit2.Response
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val service: MainService) : LoginRepository{
    override suspend fun login(email: String, password: String): Response<LoginResponse> {
        return service.login(LoginRequest(email, password))
    }
}