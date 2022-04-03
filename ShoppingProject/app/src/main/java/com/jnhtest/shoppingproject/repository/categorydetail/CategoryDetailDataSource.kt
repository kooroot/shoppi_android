package com.jnhtest.shoppingproject.repository.categorydetail

import com.jnhtest.shoppingproject.model.CategoryDetail

interface CategoryDetailDataSource {

    suspend fun getCategoryDetail(): CategoryDetail
}