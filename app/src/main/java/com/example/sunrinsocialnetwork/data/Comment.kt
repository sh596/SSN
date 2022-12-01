package com.example.sunrinsocialnetwork.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Comment(
    val comment: String,
    val id: Int,
    val user: User
)