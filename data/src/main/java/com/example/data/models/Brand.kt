package com.example.data.models

import com.example.domain.models.Brand as DomainBrand

data class Brand(
    val Brand_id: Int?,
    val Brand_name: String?,
    val Brand_slug: String?,
    val Device_count: Int?,
    val Detail: String?
)
