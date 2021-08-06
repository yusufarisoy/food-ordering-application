package com.kodluyoruz.yahnifood.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kodluyoruz.yahnifood.data.ApiRepository
import com.kodluyoruz.yahnifood.data.entity.UsersItem
import com.kodluyoruz.yahnifood.data.entity.UsersResponse
import com.kodluyoruz.yahnifood.data.entity.dtos.UserDto
import com.kodluyoruz.yahnifood.utils.Common
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {

    fun register(user: UserDto): LiveData<Resource<UsersItem>> {
        return apiRepository.register(user)
    }

    fun registerControl(email: String, password: String, name: String, surname: String): Boolean {
        return Common.isEmailValid(email) && password.length > 2 && name.length > 3 && surname.length > 3
    }
}