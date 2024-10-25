package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Header(
    val title: String,
    val iconURL: String? = null,
    val linkURL: String? = null
)
