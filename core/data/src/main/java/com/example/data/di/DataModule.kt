package com.example.data.di

import com.example.data.repository.ProductRepositoryImpl
import com.example.data_api.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class DataModule {

    @Binds
    abstract fun bindMusinsaRepositoryRepository(
        repository: ProductRepositoryImpl,
    ): ProductRepository
}