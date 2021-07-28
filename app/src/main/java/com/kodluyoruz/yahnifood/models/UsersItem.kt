package com.kodluyoruz.yahnifood.models

data class UsersItem(
    val address: Address,
    val email: String,
    val id: Int,
    val name: String,
    val password: String,
    val phone_number: String,
    val photo_url: String,
    val surname: String
)