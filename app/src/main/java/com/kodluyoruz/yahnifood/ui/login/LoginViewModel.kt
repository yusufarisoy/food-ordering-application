package com.kodluyoruz.yahnifood.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kodluyoruz.yahnifood.data.ApiRepository
import com.kodluyoruz.yahnifood.data.entity.UsersResponse
import com.kodluyoruz.yahnifood.data.local.SharedPrefManager
import com.kodluyoruz.yahnifood.utils.Common
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {

    fun login(email: String, password: String): LiveData<Resource<UsersResponse>> {
        return apiRepository.login(email, password)
    }

    fun loginControl(email: String, password: String): Boolean {
        return password.length > 2 && Common.isEmailValid(email)
    }

    fun saveToken(token: Int) {
        apiRepository.saveInt(SharedPrefManager.TOKEN, token)
    }
}