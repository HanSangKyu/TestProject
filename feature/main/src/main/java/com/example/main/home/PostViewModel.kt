package com.example.main.home

import com.airbnb.mvrx.*
import com.example.data.api.ProductApi
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostViewModel @Inject constructor(
    private val apiService: ProductApi,  // API 주입
    state: InterViewStatus  // Mavericks의 상태
) : MavericksViewModel<InterViewStatus>(state) {

    init {
        setState {
            copy(
                posts = null
            )
        }
        getTest()
    }

    private fun getTest() {
        viewModelScope.launch {
//            val response = apiService.getReservations("a")
//            // API 결과를 상태에 반영
//            setState { copy(posts = response.toString()) }
        }
    }

}
