package com.example.sunrinsocialnetwork

import com.example.sunrinsocialnetwork.UtilCode.ACCESS_TOKEN
import com.example.sunrinsocialnetwork.data.LoginResponse
import com.example.sunrinsocialnetwork.data.SearchResponse
import com.example.sunrinsocialnetwork.data.remote.MainService
import retrofit2.Response
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val service: MainService): SearchRepository{
    override suspend fun search(search: String): Response<SearchResponse> {
        return service.searchBoard("Bearer $ACCESS_TOKEN",search)
    }
}