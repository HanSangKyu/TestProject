package com.example.model
import kotlinx.serialization.Serializable

@Serializable
data class DataItem(
    val header: Header? = null,
    val contents: Content,
    val footer: Footer? = null
)