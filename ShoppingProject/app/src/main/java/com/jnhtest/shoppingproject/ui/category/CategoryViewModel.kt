package com.jnhtest.shoppingproject.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jnhtest.shoppingproject.model.Category
import com.jnhtest.shoppingproject.repository.category.CategoryRepository
import com.jnhtest.shoppingproject.ui.common.Event
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val categoryRepository: CategoryRepository
): ViewModel() {

    private val _items = MutableLiveData<List<Category>>()
    val items:LiveData<List<Category>> = _items

    private val _openCategoryEvent = MutableLiveData<Event<Category>>()
    val openCategoryEvent: LiveData<Event<Category>> = _openCategoryEvent

    init {
        loadCategory()
    }

    fun openCategoryDetail(category: Category) {
        _openCategoryEvent.value = Event(category)
    }

    fun loadCategory() {
        viewModelScope.launch {
            val categories = categoryRepository.getCategories()
            _items.value = categories
        }
    }
}