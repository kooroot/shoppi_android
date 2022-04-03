package com.jnhtest.shoppingproject.repository.category

import com.jnhtest.shoppingproject.model.Category
import com.jnhtest.shoppingproject.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient): CategoryDataSource {
    override suspend fun getCetegories(): List<Category> {
        return apiClient.getCategories()
    }
}