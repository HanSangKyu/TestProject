package com.example.model

import com.example.model.type.FooterType
import kotlinx.serialization.Serializable

@Serializable
data class Footer(
    val type: FooterType,
    val title: String,
    val iconURL: String? = null
)