package com.kodluyoruz.yahnifood.data.entity

import com.google.gson.annotations.SerializedName

data class OrderFood(
    @SerializedName("food_id")
    var food_id: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("quantity")
    var quantity: Int
)