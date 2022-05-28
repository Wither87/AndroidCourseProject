package com.example.data.models

import com.google.gson.annotations.SerializedName

data class Phone (
    @SerializedName("brand")
    val Brand: String?,
    @SerializedName("phone_name")
    val Phone_name: String?,
    @SerializedName("slug")
    val Slug: String?,
    @SerializedName("image")
    val Image: String?,
    @SerializedName("detail")
    val Detail: String?
)