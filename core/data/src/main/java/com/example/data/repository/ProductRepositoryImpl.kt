package com.example.data.repository

import com.example.data.api.ProductApi
import com.example.data_api.repository.ProductRepository
import com.example.model.Response
import javax.inject.Inject

internal class ProductRepositoryImpl @Inject constructor(
    private val reservationApi: ProductApi
) : ProductRepository {
    //    override suspend fun getCustomerVisitInfo(customerId: Long): CustomerVisitResponse {
//        return try {
//            val response = reservationApi.getCustomerDetail(customerId)
//            response
//        } catch (e: Exception) {
//            throw e
//        }
//    }
    override suspend fun getList(): Response {
        return try {
            val response = reservationApi.getProductList()
            response
        } catch (e: Exception) {
            throw e
        }
     }
}