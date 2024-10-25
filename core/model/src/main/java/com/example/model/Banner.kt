package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Banner(
    val linkURL: String="",
    val thumbnailURL: String="",
    val title: String="",
    val description: String="",
    val keyword: String=""
)