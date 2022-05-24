package com.example.data.models

import com.example.domain.models.Phone as DomainPhone

data class Phone (
    val Brand: String,
    val Phone_name: String,
    val Slug: String,
    val Image: String,
    val Detail: String
){
    fun mapToDomain() : DomainPhone{
        return DomainPhone(
            Brand=this.Brand,
            Phone_name=this.Phone_name,
            Slug=this.Slug,
            Image=this.Image,
            Detail=this.Detail
        )
    }
}
