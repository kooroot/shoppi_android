package com.jnhtest.shoppingproject.repository.home

import com.jnhtest.shoppingproject.model.HomeData

class HomeRepository(
    private val assetDataSource: HomeAssetDataSource
    ) {

    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }
}