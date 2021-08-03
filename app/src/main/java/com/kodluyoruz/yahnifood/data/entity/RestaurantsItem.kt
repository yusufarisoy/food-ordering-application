package com.kodluyoruz.yahnifood.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RestaurantsItem(
    @SerializedName("address")
    var address: Address,
    @SerializedName("average_delivery_time")
    var average_delivery_time: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("photo_url")
    var photo_url: String,
    @SerializedName("menu")
    var menu: List<Menu>?,
    @SerializedName("min_order")
    var min_order: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("owner")
    var owner: Owner,
    @SerializedName("phone_number")
    var phone_number: String,
    @SerializedName("point")
    var point: Int?,
    @SerializedName("review")
    var review: String?
): Parcelable