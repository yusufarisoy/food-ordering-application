package com.kodluyoruz.yahnifood.data.local

import android.content.Context
import android.content.SharedPreferences

class SharedPrefManager(context: Context) {
    companion object {
        const val TOKEN = "com.kodluyoruz.yahnifood.TOKEN"
        const val FIRST_LAUNCH = "com.kodluyoruz.yahnifood.first_launch"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("sharedPreferencesUtil", Context.MODE_PRIVATE)

    fun saveString(key: String, data: String) {
        sharedPreferences.edit().putString(key, data).apply()
    }

    fun getString(key: String): String? = sharedPreferences.getString(key, "")

    fun saveInt(key: String, data: Int) {
        sharedPreferences.edit().putInt(key, data).apply()
    }

    fun getInt(key: String): Int = sharedPreferences.getInt(key, -1)

    fun saveBoolean(key: String, data: Boolean) {
        sharedPreferences.edit().putBoolean(key, data).apply()
    }

    fun getBoolean(key: String): Boolean = sharedPreferences.getBoolean(key, true)
}