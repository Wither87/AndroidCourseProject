package com.example.data.models

import com.google.gson.annotations.SerializedName

data class PhoneDetails(
    @SerializedName("brand")
    val Brand: String?,
    @SerializedName("phone_name")
    val Phone_name: String?,
    @SerializedName("thumbnail")
    val Thumbnail: String?,
    @SerializedName("phone_images")
    val Phone_images: List<String>,
    @SerializedName("release_date")
    val Release_date: String?,
    @SerializedName("dimension")
    val Dimension: String?,
    @SerializedName("os")
    val Os: String?,
    @SerializedName("storage")
    val Storage: String?,
    @SerializedName("specifications")
    val Specifications: List<Specifications>,
)