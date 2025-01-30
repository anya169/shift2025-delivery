package com.example.delivery.cities

import com.example.delivery.data.CityItem

sealed interface citiesState {

    data object Initial : citiesState
    data object Loading : citiesState
    data class Failure(val message: String?) : citiesState
    data class Content(val cities: List<CityItem>) : citiesState
}