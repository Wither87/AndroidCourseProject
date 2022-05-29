package com.example.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Specs(
    @SerializedName("key")
    val Key: String?,
    @SerializedName("val")
    val Val: List<String>
)
