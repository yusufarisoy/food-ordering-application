package com.kodluyoruz.yahnifood.models

data class OrdersItem(
    val date: String,
    val id: Int,
    val note: String,
    val order_food_list: List<OrderFood>,
    val restaurant_id: Int,
    val status: Int,
    val user_id: Int
)