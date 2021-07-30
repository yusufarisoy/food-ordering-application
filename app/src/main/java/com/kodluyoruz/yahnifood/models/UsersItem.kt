package com.kodluyoruz.yahnifood.models

import com.google.gson.annotations.SerializedName

data class UsersItem(
    @SerializedName("address_list")
    var address: ArrayList<Address>,
    @SerializedName("email")
    var email: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("password")
    var password: String,
    @SerializedName("phone_number")
    var phone_number: String,
    @SerializedName("photo_url")
    var photo_url: String,
    @SerializedName("surname")
    var surname: String
)


