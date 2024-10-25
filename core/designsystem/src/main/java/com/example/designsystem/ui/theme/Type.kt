package com.example.designsystem.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.designsystem.R

private val pretendardStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.pretendard))
)

internal val Typography = ProductTypography(
    titleBold = pretendardStyle.copy(
        fontSize = 20.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight(700),
    ),
    descriptionMedium = pretendardStyle.copy(
        fontSize = 16.sp,
        lineHeight = 27.sp,
        fontWeight = FontWeight(600),
    ),
    headerTitle = pretendardStyle.copy(
        fontSize = 16.sp,
        lineHeight = 27.sp,
        fontWeight = FontWeight(700),
    ),
    headerLink = pretendardStyle.copy(
        fontSize = 14.sp,
        lineHeight = 21.sp,
        fontWeight = FontWeight(500),
    ),
    productName = pretendardStyle.copy(
        fontSize = 12.sp,
        lineHeight = 21.sp,
        fontWeight = FontWeight(500),
    ),
    price = pretendardStyle.copy(
        fontSize = 16.sp,
        lineHeight = 27.sp,
        fontWeight = FontWeight(600),
    ),
    rate = pretendardStyle.copy(
        fontSize = 16.sp,
        lineHeight = 27.sp,
        fontWeight = FontWeight(500),
    ),
    button = pretendardStyle.copy(
        fontSize = 24.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight(700),
    ),

)

@Immutable
data class ProductTypography(
    val titleBold: TextStyle,
    val descriptionMedium: TextStyle,
    val headerTitle: TextStyle,
    val headerLink: TextStyle,
    val productName: TextStyle,
    val price: TextStyle,
    val rate: TextStyle,
    val button: TextStyle,

)

val LocalTypography = staticCompositionLocalOf {
    ProductTypography(
        titleBold = pretendardStyle,
        descriptionMedium = pretendardStyle,
        headerTitle = pretendardStyle,
        headerLink = pretendardStyle,
        productName = pretendardStyle,
        price = pretendardStyle,
        rate = pretendardStyle,
        button = pretendardStyle,
    )
}