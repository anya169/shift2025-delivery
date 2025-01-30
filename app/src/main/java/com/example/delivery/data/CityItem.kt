package com.example.delivery.data

import kotlinx.serialization.Serializable

@Serializable
data class CityItem(
    val id: Long,
    val name: String,
    val latitude: Double,
    val longitude: Double
)