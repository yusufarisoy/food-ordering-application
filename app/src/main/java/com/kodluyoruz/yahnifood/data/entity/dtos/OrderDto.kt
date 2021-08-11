package com.kodluyoruz.yahnifood.data.entity.dtos

import com.google.gson.annotations.SerializedName
import com.kodluyoruz.yahnifood.data.entity.OrderFood

data class OrderDto(
    @SerializedName("date")
    var date: String,
    @SerializedName("note")
    var note: String,
    @SerializedName("order_food_list")
    var order_food_list: List<OrderFood>,
    @SerializedName("restaurant_id")
    var restaurant_id: Int,
    @SerializedName("status")
    var status: Int,
    @SerializedName("user_id")
    var user_id: Int
)