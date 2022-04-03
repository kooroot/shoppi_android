package com.jnhtest.shoppingproject.repository.productdetail

import com.jnhtest.shoppingproject.model.ProductDetail

class ProductDetailRepository (
    private val remoteDataSource: ProductDetailDataSource
) {

    suspend fun getProductDetail(productId: String): ProductDetail {
        return remoteDataSource.getProductDetail(productId)
    }
}