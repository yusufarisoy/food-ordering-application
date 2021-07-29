package com.kodluyoruz.yahnifood.models

import com.google.gson.annotations.SerializedName

data class OrdersItem(
    @SerializedName("date")
    val date: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("note")
    val note: String,
    @SerializedName("order_food_list")
    val order_food_list: List<OrderFood>,
    @SerializedName("restaurant_id")
    val restaurant_id: Int,
    @SerializedName("status")
    val status: Int,
    @SerializedName("user_id")
    val user_id: Int
)