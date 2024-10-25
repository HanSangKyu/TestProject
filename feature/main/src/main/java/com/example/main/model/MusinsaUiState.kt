package com.example.main.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.model.Response
import java.time.LocalDateTime

@Stable
sealed class MusinsaUiState {
    @Immutable
    data object Loading : MusinsaUiState()

    @Immutable
    data class Success(val data:Response) : MusinsaUiState()

    @Immutable
    data class Error(val message: String) : MusinsaUiState()
}
