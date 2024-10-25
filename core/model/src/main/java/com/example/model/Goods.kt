package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Goods(
    val linkURL: String="",
    val thumbnailURL: String="",
    val brandName: String="",
    val price: Int=0,
    val saleRate: Int=0,
    val hasCoupon: Boolean=false
)