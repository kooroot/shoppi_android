package com.jnhtest.shoppingproject.repository.category

import com.jnhtest.shoppingproject.model.Category

class CategoryRepository(
    private val remoteDataSource: CategoryRemoteDataSource
) {

    suspend fun getCategories(): List<Category> {
        return remoteDataSource.getCetegories()
    }
}