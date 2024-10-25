package com.example.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetMusinsaUseCase
import com.example.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMusinsaUseCase: GetMusinsaUseCase,
) : ViewModel() {

    private val _musinsaData = MutableStateFlow<Response?>(null)
    val musinsaData: StateFlow<Response?> = _musinsaData

    init {
        getReservationStatus()
    }

    // 예약 상태를 불러오는 함수
    fun getReservationStatus(){
        viewModelScope.launch {
            _musinsaData.value = getMusinsaUseCase()
        }
    }
}