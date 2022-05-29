package com.example.domain.models

data class Specifications(
    val Title: String?,
    val Specs: List<Specs>
){
    companion object{
        fun nullObject() = Specifications(
            Title="",
            Specs= listOf(Specs.nullObject())
        )
    }
}