package com.kodluyoruz.yahnifood.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

object SharedPreferencesUtil {
    const val TOKEN = "com.kodluyoruz.yahnifood.TOKEN"
    const val FIRST_LAUNCH_TOKEN = "com.kodluyoruz.yahnifood.first_launch"
    private var sharedPreferences: SharedPreferences? = null

    fun initSharedPreferences(context: Context) {
        sharedPreferences = context.getSharedPreferences("sharedPreferencesUtil", Context.MODE_PRIVATE)
        sharedPreferences?.registerOnSharedPreferenceChangeListener { sharedPreferences, key ->
            Log.v("SharedPref", "$key changed ${sharedPreferences.all}")
        }
    }

    fun unRegister() {
        sharedPreferences?.unregisterOnSharedPreferenceChangeListener { _, _ ->

        }
    }

    fun saveString(key: String, value: String) {
        sharedPreferences?.let {
            val editor = it.edit()
            editor.putString(key, value)
            editor.apply()
        }
    }

    fun getString(key: String, defaultVal: String = ""): String {
        return sharedPreferences?.getString(key, defaultVal) ?: ""
    }

    fun saveBoolean(key: String, value: Boolean) {
        sharedPreferences?.let {
            val editor = it.edit()
            editor.putBoolean(key, value)
            editor.apply()
        }
    }

    fun getBoolean(key: String, defaultVal: Boolean = false): Boolean {
        return sharedPreferences?.getBoolean(key, defaultVal) ?: true
    }

    fun saveToken(value: String) {
        saveString(
            TOKEN, value
        )
    }

    fun getToken(): String {
        return getString(TOKEN)
    }
}