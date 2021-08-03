package com.kodluyoruz.yahnifood.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(
    @SerializedName("title")
    var title: String,
    @SerializedName("add_date")
    var add_date: String,
    @SerializedName("address")
    var address: String,
    @SerializedName("city")
    var city: String,
    @SerializedName("district")
    var district: String,
    @SerializedName("last_update")
    var last_update: String
): Parcelable