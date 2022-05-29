package com.example.domain.models

data class Specs(
    val Key: String?,
    val Val: List<String>
){
    companion object{
        fun nullObject() = Specs(
            Key="",
            Val= listOf("")
        )
    }
}