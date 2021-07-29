package com.kodluyoruz.yahnifood.models

import com.google.gson.annotations.SerializedName

data class OrderFood(
    @SerializedName("food_id")
    val food_id: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("quantity")
    val quantity: Int
)