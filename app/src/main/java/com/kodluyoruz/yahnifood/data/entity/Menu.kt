package com.kodluyoruz.yahnifood.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Menu(
    @SerializedName("food_id")
    var food_id: Int,
    @SerializedName("ingredients")
    var ingredients: String,
    @SerializedName(" name")
    var name: String,
    @SerializedName("photo_url:")
    var photo_url: String,
    @SerializedName("price")
    var price: Double
): Parcelable