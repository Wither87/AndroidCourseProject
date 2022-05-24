package com.example.data.models

import com.example.domain.models.Specs as DomainSpecs

data class Specs(
    val Key: String,
    val Val: List<String>
){
    fun mapToDomain() : DomainSpecs{
        return DomainSpecs(
            Key=this.Key,
            Val=this.Val
        )
    }
}
