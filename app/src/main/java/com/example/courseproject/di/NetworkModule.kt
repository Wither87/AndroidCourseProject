package com.example.courseproject.di

import com.example.data.api.RetrofitService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val API_URL = "https://api-mobilespecs.azharimm.site/v2/"
@Module
class NetworkModule {

    @Provides
    fun provideRetrofitService(): RetrofitService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(API_URL)
            .build()
        return retrofit.create()
    }
}