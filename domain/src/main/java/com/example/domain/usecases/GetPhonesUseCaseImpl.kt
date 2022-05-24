package com.example.domain.usecases

import com.example.domain.models.Phone
import com.example.domain.repository.PhoneRepository
import javax.inject.Inject

class GetPhonesUseCaseImpl @Inject constructor(
    val repository: PhoneRepository
) : GetPhonesUseCase {
    override suspend fun execute(brandsSlug: String): List<Phone> {
        return repository.getPhonesList(brandsSlug)
    }

}