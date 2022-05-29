package com.example.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.models.Phone

@Dao
interface PhoneDao {
    @Insert
    suspend fun insertOne(vararg phone: Phone)

    @Insert
    suspend fun insertAll(phones: List<Phone>)

    @Query("SELECT * FROM Phone WHERE Brand LIKE :brand")
    suspend fun findAllByBrandName(brand : String): List<Phone>

    @Query("SELECT * FROM Phone WHERE Phone_name LIKE :name LIMIT 1")
    suspend fun findByName(name : String): Phone?

    @Query("SELECT * FROM Phone WHERE id LIKE :id LIMIT 1")
    suspend fun findById(id : Int): Phone?

    @Query("SELECT * FROM Phone WHERE Slug LIKE :slug LIMIT 1")
    suspend fun findBySlug(slug : String): Phone?
}