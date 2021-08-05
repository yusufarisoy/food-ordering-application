package com.kodluyoruz.yahnifood.ui.restaurant_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kodluyoruz.yahnifood.data.entity.Menu
import com.kodluyoruz.yahnifood.data.entity.RestaurantsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantDetailViewModel @Inject constructor() : ViewModel() {

    private var restaurant: MutableLiveData<RestaurantsItem> = MutableLiveData()
    private var foodList: MutableLiveData<ArrayList<Menu>> = MutableLiveData()
    private var navigateToMealDetail: MutableLiveData<Menu> = MutableLiveData()

    fun getRestaurant(): LiveData<RestaurantsItem> = this.restaurant

    fun setRestaurant(restaurantsItem: RestaurantsItem) {
        this.restaurant.value = restaurantsItem
    }

    fun getFoodList(): LiveData<ArrayList<Menu>> = this.foodList

    fun setFoodList(menu: List<Menu>) {
        this.foodList.value = ArrayList(menu)
    }

    fun getNavigateToMealDetail(): LiveData<Menu> = this.navigateToMealDetail

    fun onMealClicked(menu: Menu) {
        this.navigateToMealDetail.value = menu
    }

    fun navigationToMealDetailDone() {
        this.navigateToMealDetail.value = null
    }
}