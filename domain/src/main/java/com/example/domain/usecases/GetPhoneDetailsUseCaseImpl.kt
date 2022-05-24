package com.example.domain.usecases

import com.example.domain.models.PhoneDetails
import com.example.domain.repository.PhoneDetailsRepository
import javax.inject.Inject

class GetPhoneDetailsUseCaseImpl @Inject constructor(
    val repository: PhoneDetailsRepository
) : GetPhoneDetailsUseCase {
    override suspend fun execute(phoneSlug: String): PhoneDetails? {
        return repository.getPhoneDetails(phoneSlug)
    }

}