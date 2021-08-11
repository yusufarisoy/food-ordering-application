package com.kodluyoruz.yahnifood.ui.add_restaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kodluyoruz.yahnifood.data.ApiRepository
import com.kodluyoruz.yahnifood.data.entity.RestaurantsItem
import com.kodluyoruz.yahnifood.data.entity.RestaurantsResponse
import com.kodluyoruz.yahnifood.data.entity.UsersResponse
import com.kodluyoruz.yahnifood.data.entity.dtos.RestaurantDto
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddRestaurantViewModel @Inject constructor(private val repository: ApiRepository): ViewModel() {
    fun addRestaurant(restaurant: RestaurantDto): LiveData<Resource<RestaurantsResponse>> {
       return repository.postRestaurant(restaurant)
    }
}