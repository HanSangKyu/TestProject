package com.example.main.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.model.ProductList

@Stable
sealed class MusinsaUiState {
    @Immutable
    data object Loading : MusinsaUiState()

    @Immutable
    data class Success(val data:ProductList) : MusinsaUiState()

    @Immutable
    data class Error(val message: String) : MusinsaUiState()
}
