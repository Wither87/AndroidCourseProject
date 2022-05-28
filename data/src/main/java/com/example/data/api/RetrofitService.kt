package com.example.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import com.example.data.models.*
import retrofit2.http.Query

interface RetrofitService {
    @GET("brands")
    suspend fun getBrands(): BrandsResponse

    @GET("brands/{brand_slug}")
    suspend fun getPage(@Path("brand_slug") brand_slug: String, @Query("page") page_number: Int): PageResponse

    @GET("{phone_slug}")
    suspend fun getPhoneDetails(@Path("phone_slug") phone_slug: String): PhoneResponse
}