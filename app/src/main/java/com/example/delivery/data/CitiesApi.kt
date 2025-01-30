package com.example.delivery.data

import retrofit2.http.GET

interface CitiesApi {
    @GET("city")
    suspend fun getAll(): List<CityItem>
}