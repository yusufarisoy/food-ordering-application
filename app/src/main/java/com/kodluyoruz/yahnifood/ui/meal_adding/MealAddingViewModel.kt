package com.kodluyoruz.yahnifood.ui.meal_adding

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kodluyoruz.yahnifood.data.entity.UsersResponse
import com.kodluyoruz.yahnifood.data.remote.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MealAddingViewModel @Inject constructor(val service : ApiService): ViewModel() {


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