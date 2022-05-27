package com.example.data.models

import com.example.domain.models.PhoneDetails as DomainPhoneDetails

data class PhoneDetails(
    val Brand: String,
    val Phone_name: String,
    val Thumbnail: String,
    val Phone_images: List<String>,
    val Release_date: String,
    val Dimension: String,
    val Os: String,
    val Storage: String,
    val Specifications: List<Specifications>,
)