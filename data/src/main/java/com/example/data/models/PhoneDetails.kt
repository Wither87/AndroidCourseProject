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
){
    fun mapToDomain() : DomainPhoneDetails{
        val specifications = mutableListOf<com.example.domain.models.Specifications>()
        for (spec in this.Specifications){
            specifications.add(spec.mapToDomain())
        }
        return DomainPhoneDetails(
            Brand=this.Brand,
            Phone_name=this.Phone_name,
            Thumbnail=this.Thumbnail,
            Phone_images=this.Phone_images,
            Release_date=this.Release_date,
            Dimension=this.Dimension,
            Os=this.Os,
            Storage=this.Storage,
            Specifications=specifications.toList()
        )
    }
}