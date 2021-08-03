package com.kodluyoruz.yahnifood.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodluyoruz.yahnifood.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}