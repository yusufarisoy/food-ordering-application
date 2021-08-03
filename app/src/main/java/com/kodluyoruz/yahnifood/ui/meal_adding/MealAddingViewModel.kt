package com.kodluyoruz.yahnifood.ui.meal_adding

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kodluyoruz.yahnifood.data.entity.UsersResponse
import com.kodluyoruz.yahnifood.service.ApiService
import com.kodluyoruz.yahnifood.service.RetrofitHelper
import com.kodluyoruz.yahnifood.service.UserResponseHandler


class MealAddingViewModel: ViewModel() {
    private lateinit var service :ApiService
    private lateinit var retfofitHelper : RetrofitHelper

    init {
        retfofitHelper = RetrofitHelper()
        service = retfofitHelper.service

    }
    fun add(){
        retfofitHelper.listUsers(object : UserResponseHandler{
            override fun onResponse(response: UsersResponse) {
                Log.v("Tag",response.get(0).email)
            }

            override fun onError() {

            }

        })
    }
    /*
    fun addMeal(){
        service.getUser(1).enqueue(object : Callback<UsersResponse>{
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                Log.v("Tag","${response.body()?.size}")
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Log.v("Tag",t.message!!)
            }

        })
    }


     */

}