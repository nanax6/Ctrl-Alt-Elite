package com.example.parquescolombia.data

import com.example.parquescolombia.model.Parques
import retrofit2.http.GET

interface ApiService {
    @GET("deimerin/json-server1/parks/")
    suspend fun getParks(): Parques
}