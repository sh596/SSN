package com.example.sunrinsocialnetwork.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MealResponse(
    val date: String,
    val meal: String
)