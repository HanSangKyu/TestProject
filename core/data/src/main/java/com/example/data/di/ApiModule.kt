package com.example.data.di

import com.example.data.api.ProductApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {
    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        // 로그 인터셉터 추가
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // 필요한 로그 레벨 설정 (BODY, HEADERS, BASIC, NONE)
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor) // 인터셉터 추가
            .build()
    }

    @Provides
    @Singleton
    fun provideConverterFactory(
        json: Json,
    ): Converter.Factory {
        return json.asConverterFactory("application/json".toMediaType())
    }

    @Provides
    @Singleton
    fun provideProductApi(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
    ): ProductApi {
        return Retrofit.Builder()
            .baseUrl("https://meta.musinsa.com/")
            .addConverterFactory(converterFactory)
            .client(okHttpClient).build()
            .create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }
}