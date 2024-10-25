package com.example.main.common

object PaymentMethod {
    const val CARD = "CARD"
    const val BANK = "BANK"
    const val VBANK = "VBANK"
    const val ONSITE = "ONSITE"

    // 한글로 표시하는 함수
    fun getDisplayName(method: String): String {
        return when (method) {
            CARD -> "카드 결제"
            BANK -> "계좌이체"
            VBANK -> "무통장입금"
            ONSITE -> "현장결제"
            else -> "알 수 없는 결제 수단"
        }
    }
}