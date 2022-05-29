package com.example.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.models.PhoneDetails

@Dao
interface PhoneDetailsDao {
    @Insert
    suspend fun insertOne(vararg phones: PhoneDetails)

    @Query("SELECT * FROM PhoneDetails WHERE Phone_name LIKE :name LIMIT 1")
    suspend fun findByName(name : String): PhoneDetails?

    @Query("SELECT * FROM PhoneDetails WHERE id LIKE :id LIMIT 1")
    suspend fun findById(id : Int): PhoneDetails?
}