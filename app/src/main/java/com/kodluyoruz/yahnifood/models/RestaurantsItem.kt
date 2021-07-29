package com.kodluyoruz.yahnifood.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RestaurantsItem(
    @SerializedName("address")
    val address: Address,
    @SerializedName("average_delivery_time")
    val average_delivery_time: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("photo_url")
    val photo_url: String,
    @SerializedName("menu")
    val menu: List<Menu>?,
    @SerializedName("min_order")
    val min_order: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("owner")
    val owner: Owner,
    @SerializedName("phone_number")
    val phone_number: String,
    @SerializedName("point")
    val point: Int?,
    @SerializedName("review")
    val review: String?
): Parcelable