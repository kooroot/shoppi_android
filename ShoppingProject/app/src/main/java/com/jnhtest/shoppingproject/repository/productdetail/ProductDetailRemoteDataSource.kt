package com.jnhtest.shoppingproject.repository.productdetail

import com.jnhtest.shoppingproject.model.ProductDetail
import com.jnhtest.shoppingproject.network.ApiClient

class ProductDetailRemoteDataSource (
    private val api: ApiClient
) : ProductDetailDataSource {

    override suspend fun getProductDetail(productId: String): ProductDetail {
        return api.getProductDetail(productId)
    }
}