package com.kodluyoruz.yahnifood.data.entity.dtos

import com.google.gson.annotations.SerializedName
import com.kodluyoruz.yahnifood.data.entity.Address
import com.kodluyoruz.yahnifood.data.entity.Menu
import com.kodluyoruz.yahnifood.data.entity.Owner

data class RestaurantDto(
    @SerializedName("address")
    var address: Address,
    @SerializedName("average_delivery_time")
    var average_delivery_time: Int,
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

)