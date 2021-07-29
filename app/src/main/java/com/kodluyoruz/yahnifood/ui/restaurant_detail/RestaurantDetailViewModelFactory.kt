package com.kodluyoruz.yahnifood.ui.restaurant_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class RestaurantDetailViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RestaurantDetailViewModel::class.java)) {
            return RestaurantDetailViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}