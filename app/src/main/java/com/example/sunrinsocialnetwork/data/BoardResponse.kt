package com.example.sunrinsocialnetwork.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BoardResponse(
    val `data`: List<Data>
)