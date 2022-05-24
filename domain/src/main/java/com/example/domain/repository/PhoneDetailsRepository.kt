package com.example.domain.repository

import com.example.domain.models.PhoneDetails

interface PhoneDetailsRepository {
    suspend fun getPhoneDetails(phoneSlug: String) : PhoneDetails?
}