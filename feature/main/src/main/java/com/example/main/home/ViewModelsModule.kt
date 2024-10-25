package com.example.main.home

import com.airbnb.mvrx.hellohilt.ProductMavericksViewModel
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.MavericksViewModelComponent
import com.airbnb.mvrx.hilt.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap


@Module
@InstallIn(MavericksViewModelComponent::class)
interface ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(ProductMavericksViewModel::class)
    fun helloViewModelFactory(factory: ProductMavericksViewModel.Factory): AssistedViewModelFactory<*, *>
}
