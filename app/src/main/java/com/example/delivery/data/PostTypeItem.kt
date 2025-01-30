package com.example.delivery.data

import kotlinx.serialization.Serializable

@Serializable
data class PostTypeItem(
    val id: Long,
    val name: String,
    val length: Int,
    val width: Int,
    val weight: Int,
    val height: Int
)