package com.example.data.repository

import com.example.data.api.RetrofitService
import com.example.domain.models.PhoneDetails
import com.example.domain.repository.PhoneDetailsRepository
import javax.inject.Inject

class PhoneDetailsRepositoryImpl @Inject constructor(
    private val service: RetrofitService
) : PhoneDetailsRepository {
    override suspend fun getPhoneDetails(phoneSlug: String): PhoneDetails? {
        val response = service.getPhoneDetails(phoneSlug)
        if (response.status) {
            return response.data.mapToDomain()
        }
        return null
    }
}