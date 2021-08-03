package com.kodluyoruz.yahnifood.data.local

import javax.inject.Inject

class LocalDataSource @Inject constructor(val sharedPrefManager: SharedPrefManager) {

    fun saveToken(token: String) {
        sharedPrefManager.saveToken(token)
    }

    fun getToken(): String? {
        return sharedPrefManager.getToken()
    }
}