package com.kodluyoruz.yahnifood.ui.restaurant_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kodluyoruz.yahnifood.models.Menu
import com.kodluyoruz.yahnifood.models.RestaurantsItem

class RestaurantDetailViewModel : ViewModel() {

    private var restaurant: MutableLiveData<RestaurantsItem> = MutableLiveData()
    private var foodList: MutableLiveData<ArrayList<Menu>> = MutableLiveData()
    private var navigateToMealDetail: MutableLiveData<Menu> = MutableLiveData()

    fun getRestaurant(): LiveData<RestaurantsItem> = this.restaurant

    fun setRestaurant(restaurantsItem: RestaurantsItem) {
        this.restaurant.value = restaurantsItem
    }

    fun getFoodList(): LiveData<ArrayList<Menu>> = this.foodList

    fun setFoodList(menu: ArrayList<Menu>) {
        this.foodList.value = menu
    }

    fun getNavigateToMealDetail(): LiveData<Menu> = this.navigateToMealDetail

    fun onMealClicked(menu: Menu) {
        this.navigateToMealDetail.value = menu
    }

    fun navigationToMealDetailDone() {
        this.navigateToMealDetail.value = null
    }
}