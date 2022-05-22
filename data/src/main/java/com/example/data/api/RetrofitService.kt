package com.example.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import com.example.data.models.*

interface RetrofitService {
    @GET("")
    suspend fun getBrandsList(): List<Brand>

    @GET("")
    suspend fun getPage(): Page

    @GET("")
    suspend fun getPhonesList(): List<Phone>

    @GET("")
    suspend fun getPhoneDetails(): PhoneDetails

    @GET("")
    suspend fun getSpecificationsList(): List<Specifications>

    @GET("")
    suspend fun getSpecsList(): List<Specs>

//    @GET("path/{id}")
//    suspend fun getPersonalInfo(@Path("id") id: Int): PersonalInfo
}