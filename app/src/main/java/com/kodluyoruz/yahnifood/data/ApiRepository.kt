package com.kodluyoruz.yahnifood.data

import com.kodluyoruz.yahnifood.data.entity.OrdersItem
import com.kodluyoruz.yahnifood.data.entity.RestaurantsItem
import com.kodluyoruz.yahnifood.data.entity.UsersItem
import com.kodluyoruz.yahnifood.data.entity.dtos.UserDto
import com.kodluyoruz.yahnifood.data.local.LocalDataSource
import com.kodluyoruz.yahnifood.data.remote.RemoteDataSource
import com.kodluyoruz.yahnifood.utils.performNetworkOperation
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private var remoteDataSource: RemoteDataSource,
    private var localDataSource: LocalDataSource
) {


    fun getUserWithId(id: Int) = performNetworkOperation {
        remoteDataSource.getUser(id)
    }

    fun login(email: String, password: String) = performNetworkOperation {
        remoteDataSource.postLogin(email, password)
    }

    fun register(user: UserDto) = performNetworkOperation {
        remoteDataSource.postRegister(user)
    }

    fun getOrders(user_id: Int) = performNetworkOperation {
        remoteDataSource.getOrderList(user_id)
    }

    fun getRestaurants(district: String) = performNetworkOperation {
        remoteDataSource.getRestaurantList(district)
    }

    fun postOrder(order: OrdersItem) = performNetworkOperation {
        remoteDataSource.postOrder(order)
    }

    fun addMeal(id:String,restaurantsItem: RestaurantsItem) = performNetworkOperation {
        remoteDataSource.addMeal(id,restaurantsItem)
    }


    //Local
    fun saveString(key: String, data: String) {
        this.localDataSource.saveString(key, data)
    }

    fun getString(key: String): String? = this.localDataSource.getString(key)

    fun saveInt(key: String, data: Int) {
        this.localDataSource.saveInt(key, data)
    }

    fun getInt(key: String): Int = this.localDataSource.getInt(key)

    fun saveBoolean(key: String, data: Boolean) {
        this.localDataSource.saveBoolean(key, data)
    }

    fun getBoolean(key: String): Boolean = this.localDataSource.getBoolean(key)
}