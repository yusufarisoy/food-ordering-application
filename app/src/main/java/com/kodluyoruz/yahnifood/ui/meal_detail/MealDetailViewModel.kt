package com.kodluyoruz.yahnifood.ui.meal_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MealDetailViewModel:ViewModel() {
    private val _amount = MutableLiveData<Int>()
    val amount : LiveData<Int>
    get() = _amount
    init {
        _amount.value = 1
    }

    fun addAmount(){
        _amount.value = _amount.value?.plus(1)
    }
    fun decreaseAmount(){
        if(_amount.value != 1) _amount.value = _amount.value?.minus(1)
    }


}