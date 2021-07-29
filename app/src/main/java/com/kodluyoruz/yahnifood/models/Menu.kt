package com.kodluyoruz.yahnifood.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Menu(
    @SerializedName("food_id")
    val food_id: Int,
    @SerializedName("ingredients")
    val ingredients: String,
    @SerializedName(" name")
    val name: String,
    @SerializedName("photo_url:")
    val photo_url: String,
    @SerializedName("price")
    val price: Double
): Parcelable