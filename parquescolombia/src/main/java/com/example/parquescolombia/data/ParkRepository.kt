package com.example.parquescolombia.data

class ParkRepository {
    suspend fun getParks() = ApiFactory.retrofit.getParks()
}