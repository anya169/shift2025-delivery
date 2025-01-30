package com.example.delivery.data

import retrofit2.http.GET

interface PostTypesApi{

    @GET("postType")
    suspend fun getAll(): List<PostTypeItem>
}