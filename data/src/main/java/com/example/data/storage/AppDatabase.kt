package com.example.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.models.*
import com.example.data.type_converters.PhoneImagesConverter
import com.example.data.type_converters.SpecificationsConverter

@Database(entities = [Brand::class, Phone::class, PhoneDetails::class], version = 1)
@TypeConverters(PhoneImagesConverter::class, SpecificationsConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun brandDao(): BrandDao
    abstract fun phoneDao(): PhoneDao
    abstract fun phoneDetailsDao() : PhoneDetailsDao
}