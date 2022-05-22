package com.example.data.models

data class Page (
    val title: String,
    val Current_page: Int,
    val Last_page: Int,
    val Phones: List<Phone>
)