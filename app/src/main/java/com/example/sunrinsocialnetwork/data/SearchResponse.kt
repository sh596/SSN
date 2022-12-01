package com.example.sunrinsocialnetwork.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponse(
    val data: List<Data>
)