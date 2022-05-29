package com.example.data.repository

import com.example.data.api.RetrofitService
import com.example.domain.models.Brand as DomainBrand
import com.example.domain.repository.BrandsRepository
import javax.inject.Inject
import com.example.data.models.mapToDomain
import com.example.data.storage.BrandDao

import com.example.data.models.Brand

class BrandsRepositoryImpl @Inject constructor(
    private val service: RetrofitService,
    private val brandDao: BrandDao
): BrandsRepository {
    override suspend fun getBrandsList() : List<DomainBrand> {
        try{
            val response = service.getBrands()
            if(response.status){
                for (brand in response.data){
                    if (brandDao.findByBrandId(brand.Brand_id!!) == null){
                        brandDao.insertOne(brand)
                    }
                }
                return mapToDomain(response.data)
            }
        }
        catch (e: Exception){
            val bs = brandDao.findAll()
            return mapToDomain(bs)
        }

        return listOf()
    }

    private fun mapToDomain(list: List<Brand>): List<DomainBrand>{
        val brands = mutableListOf<DomainBrand>()
        for(brand in list){
            val b = brand.mapToDomain()
            brands.add(b)
        }
        return brands
    }
}