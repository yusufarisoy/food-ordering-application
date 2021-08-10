package com.kodluyoruz.yahnifood.ui.order_history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kodluyoruz.yahnifood.data.ApiRepository
import com.kodluyoruz.yahnifood.data.entity.OrdersResponse
import com.kodluyoruz.yahnifood.data.entity.UsersResponse
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderHistoryViewModel @Inject constructor(
    var apiRepository: ApiRepository
) : ViewModel() {

    fun getUser(user_id: Int): LiveData<Resource<UsersResponse>> {
        return apiRepository.getUserWithId(user_id)
    }
    fun getOrders(user_id: Int): LiveData<Resource<OrdersResponse>> {
        return apiRepository.getOrders(user_id)
    }
}