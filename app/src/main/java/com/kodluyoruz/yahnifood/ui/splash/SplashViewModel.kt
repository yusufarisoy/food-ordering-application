package com.kodluyoruz.yahnifood.ui.splash

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kodluyoruz.yahnifood.utils.SharedPreferencesUtil

class SplashViewModel : ViewModel() {

    private var firstLaunch: MutableLiveData<Boolean> = MutableLiveData()

    fun isFirstLaunch(): LiveData<Boolean> = this.firstLaunch

    fun handleAppLaunch() {
        Handler().postDelayed({
            this.firstLaunch.value = SharedPreferencesUtil.getBoolean(SharedPreferencesUtil.FIRST_LAUNCH_TOKEN, true)
        }, 1000)
    }

    fun saveFirstLaunch() {
        SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.FIRST_LAUNCH_TOKEN, false)
    }

    fun navigationDone() {
        this.firstLaunch.value = null
    }
}