package com.example.sunrinsocialnetwork

import com.example.sunrinsocialnetwork.data.BoardResponse
import com.example.sunrinsocialnetwork.data.MealResponse
import retrofit2.Response

interface BoardRepository {
    suspend fun getBoard(): Response<BoardResponse>
    suspend fun getMeal(): Response<MealResponse>
}