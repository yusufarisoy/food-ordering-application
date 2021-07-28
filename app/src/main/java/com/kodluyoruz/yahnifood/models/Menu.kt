package com.kodluyoruz.yahnifood.models

data class Menu(
    val food_id: Int,
    val ingredients: String,
    val name: String,
    val photo_url: String,
    val price: Double
)