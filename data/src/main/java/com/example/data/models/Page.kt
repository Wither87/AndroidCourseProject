package com.example.data.models

import com.google.gson.annotations.SerializedName

data class Page (
    @SerializedName("title")
    val title: String?,
    @SerializedName("current_page")
    val Current_page: Int,
    @SerializedName("last_page")
    val Last_page: Int,
    @SerializedName("phones")
    val Phones: List<Phone>
)