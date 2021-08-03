package com.kodluyoruz.yahnifood

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class YahniApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}