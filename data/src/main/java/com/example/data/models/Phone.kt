package com.example.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Phone (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
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