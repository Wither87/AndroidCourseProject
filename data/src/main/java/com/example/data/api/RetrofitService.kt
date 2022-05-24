package com.example.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import com.example.data.models.*

interface RetrofitService {
    @GET("brands")
    suspend fun getBrands(): BrandsResponse

    @GET("brands/{brand_slug}?page={page_number}}")
    suspend fun getPage(@Path("slug") brand_slug: String, @Path("page_number") page_number: Int): PageResponse

    @GET("{phone_slug}")
    suspend fun getPhoneDetails(@Path("phone_slug") phone_slug: String): PhoneResponse
}