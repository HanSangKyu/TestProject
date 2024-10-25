package com.airbnb.mvrx.hellohilt

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.example.main.home.InterViewStatus
import com.example.model.Response
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


class ProductMavericksViewModel @AssistedInject constructor(
    @Assisted state: InterViewStatus,
) : MavericksViewModel<InterViewStatus>(state) {
    fun setData(selectedDate: Response) {
        setState {
            copy(
                posts = selectedDate,
            )

        }
    }

    fun setLink(clickLink: String) {
        setState {
            copy(
                link = clickLink,
            )

        }
    }

    init {
        setState {
            copy(
                posts = null,
                link = ""
            )
        }
    }


    @AssistedFactory
    interface Factory : AssistedViewModelFactory<ProductMavericksViewModel, InterViewStatus> {
        override fun create(state: InterViewStatus): ProductMavericksViewModel
    }

    companion object : MavericksViewModelFactory<ProductMavericksViewModel, InterViewStatus> by hiltMavericksViewModelFactory()
}
