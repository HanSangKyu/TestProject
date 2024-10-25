package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductList(
    val data: List<DataItem>
)