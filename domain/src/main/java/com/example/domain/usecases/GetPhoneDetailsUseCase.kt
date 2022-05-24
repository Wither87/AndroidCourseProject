package com.example.domain.usecases

import com.example.domain.models.PhoneDetails

interface GetPhoneDetailsUseCase {
    suspend fun execute(phoneSlug: String) : PhoneDetails?
}