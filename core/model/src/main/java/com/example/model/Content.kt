package com.example.model

import com.example.model.type.ContentType
import kotlinx.serialization.Serializable

@Serializable
data class Content(
    val type: ContentType,
    val banners: List<Banner>? = null,
    val goods: List<Goods>? = null,
    val styles: List<Style>? = null
)