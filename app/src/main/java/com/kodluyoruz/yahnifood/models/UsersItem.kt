package com.kodluyoruz.yahnifood.models

import com.google.gson.annotations.SerializedName

data class UsersItem(
    @SerializedName("address")
    val address: Address,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone_number")
    val phone_number: String,
    @SerializedName("photo_url")
    val photo_url: String,
    @SerializedName("surname")
    val surname: String
)


