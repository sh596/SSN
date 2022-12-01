package com.example.sunrinsocialnetwork

import com.example.sunrinsocialnetwork.UtilCode.ACCESS_TOKEN
import com.example.sunrinsocialnetwork.data.BoardResponse
import com.example.sunrinsocialnetwork.data.MealResponse
import com.example.sunrinsocialnetwork.data.remote.MainService
import retrofit2.Response
import javax.inject.Inject

class BoardRepositoryImpl @Inject constructor(private val service: MainService): BoardRepository {
    override suspend fun getBoard(): Response<BoardResponse> {
        return service.getBoard("Bearer $ACCESS_TOKEN")
    }

    override suspend fun getMeal(): Response<MealResponse> {
        return service.getMeal("Bearer $ACCESS_TOKEN")
    }
}