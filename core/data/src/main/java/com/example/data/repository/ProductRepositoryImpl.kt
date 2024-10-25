package com.example.data.repository

import com.example.data.api.ProductApi
import com.example.data_api.repository.ProductRepository
import com.example.model.ProductList
import javax.inject.Inject

internal class ProductRepositoryImpl @Inject constructor(
    private val reservationApi: ProductApi
) : ProductRepository {

    override suspend fun getList(): ProductList {
        return try {
            val response = reservationApi.getProductList()
            response
        } catch (e: Exception) {
            throw e
        }
     }
}