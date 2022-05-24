package com.example.domain.repository

import com.example.domain.models.Phone

interface PhoneRepository {
    suspend fun getPhonesList(brandSlug: String) : List<Phone>
}