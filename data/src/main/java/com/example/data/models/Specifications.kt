package com.example.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Specifications(
    @SerializedName("title")
    val Title: String?,
    @SerializedName("specs")
    val Specs: List<Specs>
)