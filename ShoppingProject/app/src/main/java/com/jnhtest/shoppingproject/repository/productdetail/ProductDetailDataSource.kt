package com.jnhtest.shoppingproject.repository.productdetail

import com.jnhtest.shoppingproject.model.ProductDetail

interface ProductDetailDataSource {

    suspend fun getProductDetail(productId: String): ProductDetail
}