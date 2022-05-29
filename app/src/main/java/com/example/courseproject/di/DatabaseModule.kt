package com.example.courseproject.di

import android.content.Context
import androidx.room.Room
import com.example.data.storage.*
import com.example.data.type_converters.PhoneImagesConverter
import com.example.data.type_converters.SpecificationsConverter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase{
        return Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideBrandDao(appDatabase: AppDatabase): BrandDao {
        return appDatabase.brandDao()
    }

    @Provides
    fun providePhoneDao(appDatabase: AppDatabase): PhoneDao {
        return appDatabase.phoneDao()
    }

    @Provides
    fun providePhoneDetailsDao(appDatabase: AppDatabase): PhoneDetailsDao {
        return appDatabase.phoneDetailsDao()
    }
}