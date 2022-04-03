package com.jnhtest.shoppingproject.repository.home

import com.jnhtest.shoppingproject.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}