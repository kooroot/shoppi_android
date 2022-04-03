package com.jnhtest.shoppingproject.repository.categorydetail

import com.jnhtest.shoppingproject.model.CategoryDetail
import com.jnhtest.shoppingproject.network.ApiClient

class CategoryDetailRemoteDataSource(private val api: ApiClient) : CategoryDetailDataSource {
    override suspend fun getCategoryDetail(): CategoryDetail {
        return api.getCategoryDetail()
    }
}