package com.example.domain.repository

import com.example.domain.models.Brand

interface BrandsRepository {
    suspend fun getBrandsList() : List<Brand>
}