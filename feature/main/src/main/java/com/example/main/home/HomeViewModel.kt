package com.example.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetMusinsaUseCase
import com.example.main.model.MusinsaUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMusinsaUseCase: GetMusinsaUseCase,
) : ViewModel() {

    private val _musinsaData = MutableStateFlow<MusinsaUiState>(MusinsaUiState.Loading)
    val musinsaData: StateFlow<MusinsaUiState> = _musinsaData

    init {
        getReservationStatus()
    }

    // 예약 상태를 불러오는 함수
    fun getReservationStatus(){
        viewModelScope.launch {
            _musinsaData.value = MusinsaUiState.Loading
            try {
                val productList = getMusinsaUseCase()
                if (productList != null) {
                    _musinsaData.value = MusinsaUiState.Success(productList)
                }
            } catch (e: Exception) {
                _musinsaData.value = MusinsaUiState.Error("Error")
            }

        }
    }
}