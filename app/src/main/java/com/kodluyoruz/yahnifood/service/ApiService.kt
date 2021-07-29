package com.kodluyoruz.yahnifood.service

import com.kodluyoruz.yahnifood.models.OrdersResponse
import com.kodluyoruz.yahnifood.models.RestaurantsResponse
import com.kodluyoruz.yahnifood.models.UsersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users")
    fun getUsers(): Call<UsersResponse>

    @GET("restaurants")
    fun getRestaurants(): Call<RestaurantsResponse>

    @GET("orders")
    fun getOrders(): Call<OrdersResponse>
}