package com.example.sunrinsocialnetwork.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter=true)
data class SignUpRequest(
    val email: String,
    val password: String,
    @Json(name = "username")
    val userName: String,
)