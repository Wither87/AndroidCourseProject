package com.example.kourseproject.di

import com.example.data.api.RetrofitService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class NetworkModule {

    @Provides
    fun provideRetrofitService(): RetrofitService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api-mobilespecs.azharimm.site/v2") // подствить url
            .build()
        return retrofit.create()
    }
}