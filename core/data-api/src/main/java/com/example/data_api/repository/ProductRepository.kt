package com.example.data_api.repository

import com.example.model.Response

interface ProductRepository {
    suspend fun getList(): Response
}