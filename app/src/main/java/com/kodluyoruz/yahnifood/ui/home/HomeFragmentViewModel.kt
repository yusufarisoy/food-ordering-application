package com.kodluyoruz.yahnifood.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kodluyoruz.yahnifood.data.ApiRepository
import com.kodluyoruz.yahnifood.data.entity.RestaurantsItem
import com.kodluyoruz.yahnifood.data.entity.RestaurantsResponse
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(private val repository: ApiRepository): ViewModel() {
    fun getRestaurantsByDistrict(district:String): LiveData<Resource<RestaurantsResponse>>{
        if(district.equals("")){
            return repository.getAllRestaurants()
        }
        return repository.getRestaurants(district)
    }
}