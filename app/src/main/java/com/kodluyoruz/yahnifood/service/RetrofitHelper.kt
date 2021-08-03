package com.kodluyoruz.yahnifood.service

import android.util.Log
import com.kodluyoruz.yahnifood.data.entity.OrdersResponse
import com.kodluyoruz.yahnifood.data.entity.RestaurantsResponse
import com.kodluyoruz.yahnifood.data.entity.UsersResponse
import com.kodluyoruz.yahnifood.utils.SharedPreferencesUtil
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//interface UserResponseHandler {
//    fun onResponse(response: UsersResponse)
//    fun onError()
//}
//
//interface RestaurantResponseHandler {
//    fun onResponse(response: RestaurantsResponse)
//    fun onError()
//}
//
//interface OrderResponseHandler {
//    fun onResponse(response: OrdersResponse)
//    fun onError()
//}
//
//class RetrofitHelper {
//
//    private val okhttp: OkHttpClient = OkHttpClient.Builder()
//        .addInterceptor(Interceptor {
//            val token = SharedPreferencesUtil.getToken()
//            val request = it.request().newBuilder().addHeader("X-Token", token).build()
//            it.proceed(request)
//        })
//        .addInterceptor(
//            HttpLoggingInterceptor()
//                .setLevel(HttpLoggingInterceptor.Level.HEADERS)
//        )
//
//        .build()
//
//    private var retrofit: Retrofit = Retrofit.Builder()
//        .baseUrl("http://10.0.2.2:3000/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(okhttp)
//        .build()
//    var service:ApiService = retrofit.create(ApiService::class.java)
//
//
//
//    fun listUsers(callBack: UserResponseHandler) {
//        service.getUser(1).enqueue(object : Callback<UsersResponse> {
//            override fun onResponse(
//                call: Call<UsersResponse>,
//                response: Response<UsersResponse>
//            ) {
//                if (response.isSuccessful) {
//                    response.body()?.let {
//                        callBack.onResponse(it)
//                    }
//                } else {
//                    callBack.onError()
//                    Log.v("RetrofitHelper", "any errors.")
//                }
//            }
//
//            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
//                Log.v("RetrofitHelper", "onFailure -> service unavailable errors.")
//                callBack.onError()
//            }
//        })
//    }
//
//    fun listRestaurants(callBack: RestaurantResponseHandler) {
//        service.getRestaurants("Kadikoy").enqueue(object : Callback<RestaurantsResponse> {
//            override fun onResponse(
//                call: Call<RestaurantsResponse>,
//                response: Response<RestaurantsResponse>
//            ) {
//                if (response.isSuccessful) {
//                    response.body()?.let {
//                        callBack.onResponse(it)
//                    }
//                } else {
//                    callBack.onError()
//                    Log.v("RetrofitHelper", "any errors.")
//                }
//            }
//
//            override fun onFailure(call: Call<RestaurantsResponse>, t: Throwable) {
//                Log.v("RetrofitHelper", "onFailure -> service unavailable errors.")
//                callBack.onError()
//            }
//        })
//    }
//
//
//
//
//    fun listOrders(callBack: OrderResponseHandler) {
//        service.getOrders(1).enqueue(object : Callback<OrdersResponse> {
//            override fun onResponse(
//                call: Call<OrdersResponse>,
//                response: Response<OrdersResponse>
//            ) {
//                if (response.isSuccessful) {
//                    response.body()?.let {
//                        callBack.onResponse(it)
//                    }
//                } else {
//                    callBack.onError()
//                    Log.v("RetrofitHelper", "any errors.")
//                }
//            }
//
//            override fun onFailure(call: Call<OrdersResponse>, t: Throwable) {
//                Log.v("RetrofitHelper", "onFailure -> service unavailable errors.")
//                callBack.onError()
//            }
//        })
//    }
//
//
//
//
//
//}