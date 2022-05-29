package com.example.domain.models

data class PhoneDetails (
    val id: Int,
    val Brand: String?,
    val Phone_name: String?,
    val Thumbnail: String?,
    val Phone_images: List<String>,
    val Release_date: String?,
    val Dimension: String?,
    val Os: String?,
    val Storage: String?,
    val Specifications: List<Specifications>,
){
    companion object{
        fun nullObject() = PhoneDetails(
            id=0,
            Brand="",
            Phone_name="",
            Thumbnail="",
            Phone_images= listOf(""),
            Release_date="",
            Dimension="",
            Os="",
            Storage="",
            Specifications= listOf(Specifications.nullObject())
        );
    }
}