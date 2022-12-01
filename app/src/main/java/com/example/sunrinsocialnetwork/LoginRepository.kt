package com.example.sunrinsocialnetwork

import com.example.sunrinsocialnetwork.data.LoginResponse
import retrofit2.Response

interface LoginRepository {
    suspend fun login(email: String, password: String): Response<LoginResponse>
}