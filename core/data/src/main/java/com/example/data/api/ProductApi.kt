package com.example.data.api

import com.example.model.ProductList
import retrofit2.http.GET

interface ProductApi {
    @GET("interview/list.json")
    suspend fun  getProductList():ProductList
}