package com.kodluyoruz.yahnifood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodluyoruz.yahnifood.utils.SharedPreferencesUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SharedPreferencesUtil.initSharedPreferences(baseContext)
    }

    override fun onDestroy() {
        super.onDestroy()
        SharedPreferencesUtil.unRegister()
    }
}