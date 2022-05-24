package com.example.data.models

import com.example.domain.models.Brand as DomainBrand

data class Brand(
    val Brand_id: Int,
    val Brand_name: String,
    val Brand_slug: String,
    val Device_count: Int,
    val Detail: String
){
    fun mapToDomain() : DomainBrand {
        return DomainBrand(
            Brand_id=this.Brand_id,
            Brand_name=this.Brand_name,
            Brand_slug=this.Brand_slug,
            Device_count=this.Device_count,
            Detail=this.Detail
        )
    }
}
