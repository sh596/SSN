package com.example.sunrinsocialnetwork.data.remote

import com.example.sunrinsocialnetwork.data.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface MainService {
    @POST("/auth/local")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("/auth/new")
    suspend fun signUp(@Body request: SignUpRequest): Response<SignUpResponse>

    @GET("/board/")
    suspend fun getBoard(@Header("Authorization") accessToken : String): Response<BoardResponse>

    @GET("/meal/today")
    suspend fun getMeal(@Header("Authorization") accessToken : String): Response<MealResponse>

    @GET("/board/tag/{tag}")
    suspend fun searchBoard(@Header("Authorization") accessToken : String, @Path("tag") tag: String): Response<SearchResponse>

}