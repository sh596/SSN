package com.example.sunrinsocialnetwork.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter=true)
data class LoginResponse(
    val access: String,
    val refresh: String
)