package com.example.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.models.Brand

@Dao
interface BrandDao {
    @Insert
    suspend fun insertOne(vararg brand: Brand)

    @Insert
    suspend fun insertAll(brands: List<Brand>)

    @Query("SELECT * FROM Brand")
    suspend fun findAll(): List<Brand>

    @Query("SELECT * FROM Brand WHERE id LIKE :id LIMIT 1")
    suspend fun findById(id : Int): Brand?

    @Query("SELECT * FROM Brand WHERE Brand_id LIKE :brand_id LIMIT 1")
    suspend fun findByBrandId(brand_id : Int): Brand?

    @Query("SELECT * FROM Brand WHERE Brand_slug LIKE :brandSlug LIMIT 1")
    suspend fun findByBrandSlug(brandSlug : String): Brand?
}