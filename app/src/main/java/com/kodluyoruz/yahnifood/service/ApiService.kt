package com.kodluyoruz.yahnifood.service

import com.kodluyoruz.yahnifood.models.*
import retrofit2.Call
import retrofit2.http.*

//GET /posts?title=json-server&author=typicode
//GET /posts?id=1&id=2
//GET /comments?author.name=typicode
//http://localhost:3000/users?id=2
//http://localhost:3000/restaurants?address.district=Kadikoy

interface ApiService {
    @GET("users")
    fun getUser(@Query("id") id:Int
    ): Call<UsersResponse>

    @GET("restaurants")
    fun getRestaurants(@Query("address.district") district: String
    ): Call<RestaurantsResponse>

    @GET("orders")
    fun getOrders(@Query("user_id") user_id:Int
    ): Call<OrdersResponse>


    @POST("users")
    fun postUser(@Body () user: UsersItem

    ): Call<UsersResponse>


    @POST("restaurants")
    fun postRestaurant(@Field("address") address: Address,
                       @Field("average_delivery_time") average_delivery_time: Int,
                       @Field("id") id: Int,
                       @Field("photo_url") photo_url: String,
                       @Field("menu") menu: List<Menu>?,
                       @Field("min_order") min_order: Int,
                       @Field("name") name: String,
                       @Field("owner") owner: Owner,
                       @Field("phone_number") phone_number: String,



    ): Call<RestaurantsResponse>

    @POST("orders")
    fun postOrder(): Call<OrdersResponse>


}