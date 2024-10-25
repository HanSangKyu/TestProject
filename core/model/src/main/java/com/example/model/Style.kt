package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Style(
    val linkURL: String,
    val thumbnailURL: String
)