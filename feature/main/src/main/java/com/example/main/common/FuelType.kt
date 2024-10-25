package com.example.main.common

object FuelType {
    const val PREMIUM_GASOLINE = "PREMIUM_GASOLINE"
    const val GASOLINE = "GASOLINE"
    const val DIESEL = "DIESEL"
    const val LPG = "LPG"
    const val ELECTRICITY = "ELECTRICITY"

    // 한글로 표시하는 함수
    fun getDisplayName(fuelType: String): String {
        return when (fuelType) {
            PREMIUM_GASOLINE -> "고급 휘발유"
            GASOLINE -> "일반 휘발유"
            DIESEL -> "경유"
            LPG -> "LPG"
            ELECTRICITY -> "전기"
            else -> "알 수 없는 연료 종류"
        }
    }
}