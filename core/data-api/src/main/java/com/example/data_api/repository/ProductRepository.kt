package com.example.data_api.repository

import com.example.model.ProductList

interface ProductRepository {
    suspend fun getList(): ProductList
}