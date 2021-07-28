package com.kodluyoruz.yahnifood.models

data class RestaurantsItem(
    val address: Address,
    val average_delivery_time: Int,
    val id: Int,
    val menu: List<Menu>,
    val min_order: Int,
    val name: String,
    val owner: Owner,
    val phone_number: String,
    val point: Int,
    val review: String
)