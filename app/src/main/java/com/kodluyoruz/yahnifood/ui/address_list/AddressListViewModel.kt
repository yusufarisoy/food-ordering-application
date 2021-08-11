package com.kodluyoruz.yahnifood.ui.address_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kodluyoruz.yahnifood.data.ApiRepository
import com.kodluyoruz.yahnifood.data.entity.UsersResponse
import com.kodluyoruz.yahnifood.data.local.SharedPrefManager
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddressListViewModel @Inject constructor(
    var apiRepository: ApiRepository
) : ViewModel() {

    private var token: Int = apiRepository.getInt(SharedPrefManager.TOKEN)


    fun getUser(user_id: Int): LiveData<Resource<UsersResponse>> {
        return apiRepository.getUserWithId(user_id)
    }

    fun getToken(): Int = this.token

}