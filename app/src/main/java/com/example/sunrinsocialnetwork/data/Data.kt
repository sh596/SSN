package com.example.sunrinsocialnetwork.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    val comment: List<Comment>,
    val id: Int,
    val imageUrl: String,
    val tags: String,
    val text: String,
    val user: User
)