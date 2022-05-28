package com.example.data.models

import com.google.gson.annotations.SerializedName


data class Specifications(
    @SerializedName("title")
    val Title: String?,
    @SerializedName("specs")
    val Specs: List<Specs>
)