package com.kodluyoruz.yahnifood.data.entity

import com.google.gson.annotations.SerializedName

data class OrdersItem(
    @SerializedName("date")
    var date: String,
    @SerializedName("id")
    var id: Int,
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