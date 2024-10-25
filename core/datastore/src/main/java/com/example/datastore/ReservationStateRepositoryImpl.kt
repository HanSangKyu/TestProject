package com.example.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Named

class ReservationStateRepositoryImpl @Inject constructor(
    @Named("status") private val dataStore: DataStore<Preferences>  // DataStore 주입
) : ReservationStateRepository {

    private val RESERVATION_STATUS_KEY_PREFIX = "reservation_status_"

    private fun reservationStatusKey(reservationId: Long) = stringPreferencesKey("$RESERVATION_STATUS_KEY_PREFIX$reservationId")

    override suspend fun saveReservationStatus(reservationId: Long, status: String) {
        dataStore.edit { preferences ->
            preferences[reservationStatusKey(reservationId)] = status
        }
    }

    override fun getReservationStatus(reservationId: Long): Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[reservationStatusKey(reservationId)] ?: ""
        }
    }
}