package com.kodluyoruz.yahnifood.ui.address_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kodluyoruz.yahnifood.data.entity.Address
import com.kodluyoruz.yahnifood.data.entity.UsersResponse
import com.kodluyoruz.yahnifood.service.RetrofitHelper
import com.kodluyoruz.yahnifood.service.UserResponseHandler

class AddressListViewModel : ViewModel() {
    private var retrofitHelper : RetrofitHelper = RetrofitHelper()
    private lateinit var _userAddressList : MutableLiveData<ArrayList<Address>>
    var userAddressList: LiveData<ArrayList<Address>>

    init{
        getUserAddress()
        userAddressList = _userAddressList

    }

    private fun getUserAddress(){
        retrofitHelper.listUsers(object : UserResponseHandler {
            override fun onResponse(response: UsersResponse) {
                Log.v("Tag", response[0].address[0].city)
                _userAddressList.value = response[0].address
            }

            override fun onError() {

            }

        })
    }




}