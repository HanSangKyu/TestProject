package com.example.designsystem.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val White = Color(0xFFFFFFFF)
val Black01 = Color(0xFF1A2128)
val Dark01 = Color(0x0F1A2128)
val TextTertiary = Color(0xFF8E98A0)
val ButtonTextTertiaryOutlined = Color(0xFF6D7882)
val TextAccent = Color(0xFF00AFFF)
val FieldBorderDefault = Color(0xFFF2F4F6)
val TitlePrimary = Color(0xFF1A2128)
val BackgroundLight = Color(0xFFF2F4F6)
val BackgroundAccentLight = Color(0xFFE0F5FF)
val TextSecondary = Color(0xFF6D7882)
val Divider = Color(0x1A21280F)
val ColorMainBlue500 = Color(0xFF00AFFF)
val ButtonTextTertiary = Color(0xFF505C66)
val TextOnColor = Color(0xFFFFFFFF)
val ButtonBackgroundPrimary = Color(0xFF00AFFF)
val ButtonBackgroundTertiary = Color(0xFFF2F4F6)
val LightGrayscaleGray900 = Color(0xFF1A2128)
val Rate = Color(0xFFF84848)
val TextWarning = Color(0xFFF84848)
val BackgroundWarningLight = Color(0xFFFFECEC)
val TextDisabled = Color(0xFFCFD5D9)
val BackgroundElevatedSecondary = Color(0xFFF2F4F6)
val BannerCountBox = Color( 0x706D6D6D)
val Coupon = Color(0xCC2196F3)

sealed class ColorSet {
    open lateinit var colors: MyColors

    object Default : ColorSet() {
        override var colors = MyColors(
            buttonTextTertiaryOutlined = ButtonTextTertiaryOutlined,
            textAccent = TextAccent,
            fieldBorderDefault = FieldBorderDefault,
            textPrimary = TitlePrimary,
            backgroundLight = BackgroundLight,
            backgroundAccentLight = BackgroundAccentLight,
            textSecondary = TextSecondary,
            textTertiary = TextTertiary,
            divider = Divider,
            colorMainBlue500 = ColorMainBlue500,
            buttonTextTertiary = ButtonTextTertiary,
            textOnColor = TextOnColor,
            buttonBackgroundPrimary = ButtonBackgroundPrimary,
            buttonBackgroundTertiary = ButtonBackgroundTertiary,
            lightGrayscaleGray900 = LightGrayscaleGray900,
            textWarning = TextWarning,
            backgroundWarningLight = BackgroundWarningLight,
            textDisabled = TextDisabled,
            backgroundElevatedSecondary = BackgroundElevatedSecondary
        )
    }
}