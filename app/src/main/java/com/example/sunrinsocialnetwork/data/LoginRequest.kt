package com.example.sunrinsocialnetwork.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter=true)
data class LoginRequest(
    val email: String,
    val password: String
)