package com.example.data.models

import com.google.gson.annotations.SerializedName

data class Specs(
    @SerializedName("key")
    val Key: String?,
    @SerializedName("val")
    val Val: List<String>
)
