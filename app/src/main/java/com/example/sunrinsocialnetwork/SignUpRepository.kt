package com.example.sunrinsocialnetwork

import com.example.sunrinsocialnetwork.data.SignUpResponse
import retrofit2.Response

interface SignUpRepository {
    suspend fun signUp(email : String, password: String, nickname: String) : Response<SignUpResponse>
}