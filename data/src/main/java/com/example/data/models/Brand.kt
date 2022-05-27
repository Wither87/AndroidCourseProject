package com.example.data.models

import com.google.gson.annotations.SerializedName

data class Brand(
    @SerializedName("brand_id")
    val Brand_id: Int?,
    @SerializedName("brand_name")
    val Brand_name: String?,
    @SerializedName("brand_slug")
    val Brand_slug: String?,
    @SerializedName("device_count")
    val Device_count: Int?,
    @SerializedName("detail")
    val Detail: String?
)
