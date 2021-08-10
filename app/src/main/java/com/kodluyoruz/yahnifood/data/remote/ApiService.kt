package com.kodluyoruz.yahnifood.data.remote

import com.kodluyoruz.yahnifood.data.entity.*
import com.kodluyoruz.yahnifood.data.entity.dtos.UserDto
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    //http://localhost:3000/users?email=yusuf@hotmail.com&name=Yusuf

    @GET("users")
    suspend fun getUser(@Query("id") id:Int
    ): Response<UsersResponse>

    @GET("users")
    suspend fun login (@Query("email") email:String, @Query("password") password:String
    ): Response<UsersResponse>

    @POST("users")
    suspend fun register(@Body() user: UserDto
    ): Response <UsersItem>

    @GET("restaurants")
    fun getRestaurants(@Query("address.district") district: String
    ): Response <RestaurantsResponse>

    @GET("orders")
    fun getOrders(@Query("user_id") user_id:Int
    ): Response <OrdersResponse>

    @POST("restaurants")
    fun postRestaurant(@Body() restaurant: RestaurantsItem
    ): Response <RestaurantsResponse>

    @POST("orders")
    fun postOrder(@Body() order: OrdersItem
    ): Response <OrdersResponse>

    @PUT("restaurants/{id}")
    suspend fun addMeal(@Path("id") id:String, @Body restaurant: RestaurantsItem) : Response<RestaurantsItem>


    @GET("restaurants")
    suspend fun getAllRestaurants():Response<RestaurantsResponse>




}


