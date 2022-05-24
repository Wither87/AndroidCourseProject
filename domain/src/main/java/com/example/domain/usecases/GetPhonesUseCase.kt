package com.example.domain.usecases

import com.example.domain.models.Phone

interface GetPhonesUseCase {
    suspend fun execute(brandsSlug: String) : List<Phone>
}