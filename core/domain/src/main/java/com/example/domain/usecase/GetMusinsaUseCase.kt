package com.example.domain.usecase

import com.example.data_api.repository.ProductRepository
import com.example.model.ProductList
import javax.inject.Inject

class GetMusinsaUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(): ProductList {
        return productRepository.getList()
    }

}