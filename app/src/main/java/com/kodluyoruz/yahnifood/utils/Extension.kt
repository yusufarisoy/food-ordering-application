package com.kodluyoruz.yahnifood.utils

import android.view.View

class Extension {


    fun View.show() {
        visibility = View.VISIBLE
    }

    fun View.hide() {
        visibility = View.INVISIBLE
    }

    fun View.gone() {
        visibility = View.GONE
    }

}