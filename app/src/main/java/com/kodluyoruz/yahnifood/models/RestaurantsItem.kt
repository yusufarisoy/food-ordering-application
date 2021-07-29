package com.kodluyoruz.yahnifood.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RestaurantsItem(
    val address: Address,
    val average_delivery_time: Int,
    val id: Int,
    val photo_url: String,
    val menu: List<Menu>,
    val min_order: Int,
    val name: String,
    val owner: Owner,
    val phone_number: String,
    val point: Int,
    val review: String
): Parcelable