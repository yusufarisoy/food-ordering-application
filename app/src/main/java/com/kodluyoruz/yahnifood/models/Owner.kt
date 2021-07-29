package com.kodluyoruz.yahnifood.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(
    val email: String,
    val name: String,
    val password: String,
    val phone_number: String,
    val surname: String
): Parcelable