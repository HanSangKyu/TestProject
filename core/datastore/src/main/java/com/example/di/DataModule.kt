package com.example.di

import com.example.datastore.ReservationStateRepository
import com.example.datastore.ReservationStateRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class DataModule {
    @Binds
    abstract fun bindReservationRepository(
        repository: ReservationStateRepositoryImpl,
    ): ReservationStateRepository

}