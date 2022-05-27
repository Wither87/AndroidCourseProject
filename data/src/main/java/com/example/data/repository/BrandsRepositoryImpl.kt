package com.example.data.repository

import android.util.Log
import com.example.data.api.RetrofitService
import com.example.domain.models.Brand
import com.example.domain.repository.BrandsRepository
import javax.inject.Inject
import com.example.data.models.mapToDomain

private const val TAG = "mytag"
class BrandsRepositoryImpl @Inject constructor(
    private val service: RetrofitService
): BrandsRepository {
    override suspend fun getBrandsList() : List<Brand> {
        val response = service.getBrands()
        val brands = mutableListOf<Brand>()
        Log.i(TAG, "status: " + response.status.toString())
        if(response.status){
            for(brand in response.data){
                val b = brand.mapToDomain()
                Log.i(TAG, "brand name: " + b.Brand_name.toString())
                brands.add(b)
            }
        }
        return brands.toList()
    }
}