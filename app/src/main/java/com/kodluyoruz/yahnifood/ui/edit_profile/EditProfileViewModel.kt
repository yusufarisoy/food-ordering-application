package com.kodluyoruz.yahnifood.ui.edit_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kodluyoruz.yahnifood.data.ApiRepository
import com.kodluyoruz.yahnifood.data.entity.UsersItem
import com.kodluyoruz.yahnifood.data.entity.UsersResponse
import com.kodluyoruz.yahnifood.data.entity.dtos.UserDto
import com.kodluyoruz.yahnifood.data.local.SharedPrefManager
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class EditProfileViewModel @Inject constructor(var apiRepository: ApiRepository) : ViewModel(){

    private var token: Int = apiRepository.getInt(SharedPrefManager.TOKEN)
    private var user: MutableLiveData<UsersItem> = MutableLiveData()

    fun getUserWithId(user_id: Int): LiveData<Resource<UsersResponse>> {
        return apiRepository.getUserWithId(user_id)
    }

    /*fun updateUser(id:String, user: UsersItem): LiveData<Resource<UsersItem>>{
        return apiRepository.updateUser(id, user)
    }*/

    fun getToken(): Int = this.token

}