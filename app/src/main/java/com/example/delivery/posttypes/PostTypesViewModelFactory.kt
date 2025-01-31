package com.example.delivery.posttypes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.delivery.data.PostTypesRepository

class PostTypesViewModelFactory(
    private val postTypesRepository: PostTypesRepository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == PostTypesViewModel::class.java) { "Unknown ViewModel: $modelClass" }
        return PostTypesViewModel(postTypesRepository) as T
    }
}