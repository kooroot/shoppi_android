package com.jnhtest.shoppingproject.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jnhtest.shoppingproject.AssetLoader
import com.jnhtest.shoppingproject.ServiceLocator
import com.jnhtest.shoppingproject.network.ApiClient
import com.jnhtest.shoppingproject.repository.category.CategoryRemoteDataSource
import com.jnhtest.shoppingproject.repository.category.CategoryRepository
import com.jnhtest.shoppingproject.repository.home.HomeAssetDataSource
import com.jnhtest.shoppingproject.repository.home.HomeRepository
import com.jnhtest.shoppingproject.repository.categorydetail.CategoryDetailRemoteDataSource
import com.jnhtest.shoppingproject.repository.categorydetail.CategoryDetailRepository
import com.jnhtest.shoppingproject.repository.productdetail.ProductDetailRemoteDataSource
import com.jnhtest.shoppingproject.repository.productdetail.ProductDetailRepository
import com.jnhtest.shoppingproject.ui.categorydetail.CategoryDetailViewModel
import com.jnhtest.shoppingproject.ui.category.CategoryViewModel
import com.jnhtest.shoppingproject.ui.home.HomeViewModel
import com.jnhtest.shoppingproject.ui.productdetail.ProductDetailViewModel

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository = CategoryRepository(CategoryRemoteDataSource(ServiceLocator.provideApiClient()))
                CategoryViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryDetailViewModel::class.java) -> {
                val repository = CategoryDetailRepository(CategoryDetailRemoteDataSource(ServiceLocator.provideApiClient()))
                CategoryDetailViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ProductDetailViewModel::class.java) -> {
                val repository = ProductDetailRepository(ProductDetailRemoteDataSource(ServiceLocator.provideApiClient()))
                ProductDetailViewModel(repository) as T
            }
            else -> {
                throw IllegalAccessException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}