package com.example.data.repository

import com.example.data.api.RetrofitService
import com.example.domain.models.Brand
import com.example.domain.repository.BrandsRepository
import javax.inject.Inject

class BrandsRepositoryImpl @Inject constructor(
    private val service: RetrofitService
): BrandsRepository {
    override suspend fun getBrandsList() : List<Brand> {
        val response = service.getBrands()
        val brands = mutableListOf<Brand>()
        if(response.status){
            for(brand in response.data){
                brands.add(brand.mapToDomain())
            }
        }
        return brands.toList()
    }
}