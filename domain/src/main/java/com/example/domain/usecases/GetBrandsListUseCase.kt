package com.example.domain.usecases

import com.example.domain.models.Brand

interface GetBrandsListUseCase {
    suspend fun execute() : List<Brand>
}