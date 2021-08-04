package com.kodluyoruz.yahnifood.data

import com.kodluyoruz.yahnifood.data.entity.OrdersItem
import com.kodluyoruz.yahnifood.data.entity.RestaurantsItem
import com.kodluyoruz.yahnifood.data.entity.UsersItem
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

    fun register(user: UsersItem) = performNetworkOperation {
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



}