package com.example.sebzemeyve.models.services

import com.example.sebzemeyve.models.SebzeMeyveResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/ibb/halfiyatlari/sebzemeyve/{date}")
    suspend fun getSebzeMeyveFiyatlar(@Path("date") date: String): SebzeMeyveResponse

}