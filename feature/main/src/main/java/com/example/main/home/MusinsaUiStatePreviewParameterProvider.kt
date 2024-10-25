package com.example.main.home

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.main.model.MusinsaUiState
import com.example.model.Response
import java.time.LocalDateTime


internal class MusinsaUiStatePreviewParameterProvider : PreviewParameterProvider<MusinsaUiState> {
    override val values: Sequence<MusinsaUiState> = sequenceOf(
        MusinsaUiState.Loading,
        MusinsaUiState.Success(
            Response(data = arrayListOf())
        ),
        MusinsaUiState.Error("An error occurred")
    )
}
