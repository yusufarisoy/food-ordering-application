package com.kodluyoruz.yahnifood.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(
    @SerializedName("add_date")
    val add_date: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("district")
    val district: String,
    @SerializedName("last_update")
    val last_update: String
): Parcelable