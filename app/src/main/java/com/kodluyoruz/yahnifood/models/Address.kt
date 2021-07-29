package com.kodluyoruz.yahnifood.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(
    val add_date: String,
    val address: String,
    val city: String,
    val district: String,
    val last_update: String
): Parcelable