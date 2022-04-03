package com.jnhtest.shoppingproject.repository.categorydetail

import com.jnhtest.shoppingproject.model.CategoryDetail

class CategoryDetailRepository (
    private val remoteDataSource: CategoryDetailRemoteDataSource
) {
    suspend fun getCategoryDetail(): CategoryDetail {
        return remoteDataSource.getCategoryDetail()
    }
}