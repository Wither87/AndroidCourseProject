package com.example.domain.usecases

import com.example.domain.models.Brand
import com.example.domain.repository.BrandsRepository
import javax.inject.Inject

class GetBrandsListUseCaseImpl @Inject constructor(
    private val repository: BrandsRepository
) : GetBrandsListUseCase {
    override suspend fun execute(): List<Brand> {
        return repository.getBrandsList()
    }
}