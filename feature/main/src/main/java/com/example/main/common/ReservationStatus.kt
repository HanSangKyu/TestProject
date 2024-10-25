package com.example.main.common

object ReservationStatus {
    const val CREATED = "CREATED"
    const val CANCELLED = "CANCELLED"
    const val CONFIRMED = "CONFIRMED"
    const val DEFERRED = "DEFERRED"
    const val COMPLETED = "COMPLETED"

    // 한글로 표시하는 함수
    fun getDisplayName(status: String): String {
        return when (status) {
            CREATED -> "예약 요청"
            CANCELLED -> "예약 취소"
            CONFIRMED -> "작업 가능"
            DEFERRED -> "작업 불가능"
            COMPLETED -> "작업 완료"
            else -> "알 수 없는 상태"
        }
    }
}