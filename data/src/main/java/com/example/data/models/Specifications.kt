package com.example.data.models

import com.example.domain.models.Specifications as DomainSpecifications
import com.example.domain.models.Specs as DomainSpecs

data class Specifications(
    val Title: String,
    val Specs: List<Specs>
)