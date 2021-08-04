package com.kodluyoruz.yahnifood.data.remote

import com.kodluyoruz.yahnifood.data.entity.OrdersItem
import com.kodluyoruz.yahnifood.data.entity.RestaurantsItem
import com.kodluyoruz.yahnifood.data.entity.UsersItem
import com.kodluyoruz.yahnifood.utils.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService) : BaseDataSource() {

    suspend fun getOrderList(id: Int) = getResult { apiService.getOrders(id) }

    suspend fun getRestaurantList(district: String) = getResult { apiService.getRestaurants(district) }

    suspend fun getUser(id: Int) = getResult { apiService.getUser(id) }

    suspend fun postRegister(user: UsersItem) = getResult { apiService.register(user) }

    suspend fun postLogin(email: String, password: String) = getResult { apiService.login(email, password) }

    suspend fun postOrder(order: OrdersItem) = getResult { apiService.postOrder(order) }

    suspend fun addMeal(id:String,restaurantsItem: RestaurantsItem) = getResult { apiService.addMeal(id,restaurantsItem) }


}