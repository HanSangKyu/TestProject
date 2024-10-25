package com.example.domain.usecase

import com.example.data_api.repository.ProductRepository
import com.example.model.Response
import javax.inject.Inject

class GetMusinsaUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(): Response {
        return productRepository.getList()
    }

}