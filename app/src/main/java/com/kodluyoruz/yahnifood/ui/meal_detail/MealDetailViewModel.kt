package com.kodluyoruz.yahnifood.ui.meal_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kodluyoruz.yahnifood.data.ApiRepository
import com.kodluyoruz.yahnifood.data.entity.OrdersItem
import com.kodluyoruz.yahnifood.data.entity.OrdersResponse
import com.kodluyoruz.yahnifood.data.entity.dtos.OrderDto
import com.kodluyoruz.yahnifood.data.local.SharedPrefManager
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealDetailViewModel @Inject constructor(private val apiRepository: ApiRepository):ViewModel() {
    private var token: Int = apiRepository.getInt(SharedPrefManager.TOKEN)
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
    fun getToken(): Int = this.token

    fun postOrder(order: OrderDto) : LiveData<Resource<OrdersResponse>>{
        return apiRepository.postOrder(order)
    }

}