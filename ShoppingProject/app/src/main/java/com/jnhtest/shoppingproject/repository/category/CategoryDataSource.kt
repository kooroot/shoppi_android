package com.jnhtest.shoppingproject.repository.category

import com.jnhtest.shoppingproject.model.Category

interface CategoryDataSource {

    suspend fun getCetegories(): List<Category>
}