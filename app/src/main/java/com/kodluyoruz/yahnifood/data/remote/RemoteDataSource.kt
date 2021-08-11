package com.kodluyoruz.yahnifood.data.remote

import com.kodluyoruz.yahnifood.data.entity.Address
import com.kodluyoruz.yahnifood.data.entity.OrdersItem
import com.kodluyoruz.yahnifood.data.entity.RestaurantsItem
import com.kodluyoruz.yahnifood.data.entity.UsersItem
import com.kodluyoruz.yahnifood.data.entity.dtos.OrderDto
import com.kodluyoruz.yahnifood.data.entity.dtos.RestaurantDto
import com.kodluyoruz.yahnifood.data.entity.dtos.UserDto
import com.kodluyoruz.yahnifood.utils.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService) : BaseDataSource() {

    suspend fun getOrderList(id: Int) = getResult { apiService.getOrders(id) }

    suspend fun getRestaurantList(district: String) = getResult { apiService.getRestaurants(district) }

    suspend fun getUser(id: Int) = getResult { apiService.getUser(id) }

    suspend fun postRegister(user: UserDto) = getResult { apiService.register(user) }

    suspend fun updateUser(id:String,user: UsersItem) = getResult { apiService.updateUser(id,user) }

    suspend fun postLogin(email: String, password: String) = getResult { apiService.login(email, password) }

    suspend fun postOrder(order: OrderDto) = getResult { apiService.postOrder(order) }

    suspend fun postAddress(address: Address) = getResult { apiService.postAddress(address) }

    suspend fun addMeal(id:String,restaurantsItem: RestaurantsItem) = getResult { apiService.addMeal(id,restaurantsItem) }

    // todo: checkpoint
    suspend fun postRestaurant(restaurant:RestaurantDto) =  getResult { apiService.postRestaurant(restaurant) }

    suspend fun getAllRestaurants() = getResult { apiService.getAllRestaurants() }



}