package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val data: List<DataItem>
)

@Serializable
data class DataItem(
    val header: Header? = null,
    val contents: Content,
    val footer: Footer? = null
)

@Serializable
data class Header(
    val title: String,
    val iconURL: String? = null,
    val linkURL: String? = null
)

@Serializable
data class Content(
    val type: ContentType,
    val banners: List<Banner>? = null,
    val goods: List<Goods>? = null,
    val styles: List<Style>? = null
)

@Serializable
data class Banner(
    val linkURL: String="",
    val thumbnailURL: String="",
    val title: String="",
    val description: String="",
    val keyword: String=""
)

@Serializable
data class Goods(
    val linkURL: String="",
    val thumbnailURL: String="",
    val brandName: String="",
    val price: Int=0,
    val saleRate: Int=0,
    val hasCoupon: Boolean=false
)

@Serializable
data class Style(
    val linkURL: String,
    val thumbnailURL: String
)

@Serializable
data class Footer(
    val type: FooterType,
    val title: String,
    val iconURL: String? = null
)

@Serializable
enum class ContentType {
    BANNER, SCROLL, STYLE,GRID
}
@Serializable
enum class FooterType {
    REFRESH, MORE
}