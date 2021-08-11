package com.kodluyoruz.yahnifood.ui.meal_adding

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kodluyoruz.yahnifood.data.ApiRepository
import com.kodluyoruz.yahnifood.data.entity.RestaurantsItem
import com.kodluyoruz.yahnifood.data.entity.UsersResponse
import com.kodluyoruz.yahnifood.data.remote.ApiService
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MealAddingViewModel @Inject constructor(val repository: ApiRepository): ViewModel() {

    fun addMeal(id:String,restaurantsItem: RestaurantsItem): LiveData<Resource<RestaurantsItem>>{
        return repository.addMeal(id,restaurantsItem)
    }
}