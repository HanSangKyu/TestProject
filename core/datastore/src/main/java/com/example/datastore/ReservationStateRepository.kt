package com.example.datastore

import kotlinx.coroutines.flow.Flow

interface ReservationStateRepository {
    suspend fun saveReservationStatus(reservationId: Long, status: String)
    fun getReservationStatus(reservationId: Long): Flow<String>
}