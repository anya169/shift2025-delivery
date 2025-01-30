package com.example.delivery.posttypes

import com.example.delivery.data.PostTypeItem

sealed interface postTypesState {



    data object Initial : postTypesState
    data object Loading : postTypesState
    data class Failure(val message: String?) : postTypesState
    data class Content(val postTypes: List<PostTypeItem>) : postTypesState
}