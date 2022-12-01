package com.example.sunrinsocialnetwork

import com.example.sunrinsocialnetwork.data.LoginResponse
import com.example.sunrinsocialnetwork.data.SearchResponse
import retrofit2.Response

interface SearchRepository {
    suspend fun search(search: String): Response<SearchResponse>
}