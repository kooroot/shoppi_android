package com.jnhtest.shoppingproject.ui.home

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jnhtest.shoppingproject.model.Banner
import com.jnhtest.shoppingproject.model.Promotion
import com.jnhtest.shoppingproject.model.Title
import com.jnhtest.shoppingproject.repository.home.HomeRepository
import com.jnhtest.shoppingproject.ui.common.Event

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> = _title

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners: LiveData<List<Banner>> = _topBanners

    private val _promotions = MutableLiveData<Promotion>()
    val promotions: LiveData<Promotion> = _promotions

    private val _openProductEvent = MutableLiveData<Event<String>>()
    val openProductEvent: LiveData<Event<String>> = _openProductEvent

    init {
        loadHomeData()
    }

    fun openProductDetail(productId: String) {
        _openProductEvent.value = Event(productId)
    }

     private fun loadHomeData() {
         val homeData = homeRepository.getHomeData()
         homeData?.let { homeData ->
             _title.value = homeData.title
             _topBanners.value = homeData.topBanners
             _promotions.value = homeData.promotions
         }

    }
}