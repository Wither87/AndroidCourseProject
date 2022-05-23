package com.example.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import com.example.data.models.*

interface RetrofitService {
    @GET("brands")
    suspend fun getBrandsList(): List<Brand>

    @GET("brands/{slug}?page={page_number}}")
    suspend fun getPage(@Path("slug") slug: String, @Path("page_number") page_number: Int): Page

    //@GET("")
    suspend fun getPhonesList(slug: String): List<Phone>

    @GET("{phone_slug}")
    suspend fun getPhoneDetails(@Path("phone_slug") phone_slug: String): PhoneDetails

    @GET("")
    suspend fun getSpecificationsList(): List<Specifications>

    @GET("")
    suspend fun getSpecsList(): List<Specs>

//    @GET("path/{id}")
//    suspend fun getPersonalInfo(@Path("id") id: Int): PersonalInfo
}