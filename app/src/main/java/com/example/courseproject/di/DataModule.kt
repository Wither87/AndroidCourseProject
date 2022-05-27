package com.example.courseproject.di

import com.example.data.repository.BrandsRepositoryImpl
import com.example.data.repository.PhoneDetailsRepositoryImpl
import com.example.data.repository.PhoneRepositoryImpl
import com.example.domain.repository.BrandsRepository
import com.example.domain.repository.PhoneDetailsRepository
import com.example.domain.repository.PhoneRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindBrandsRepository(brandsRepositoryImpl: BrandsRepositoryImpl) : BrandsRepository

    @Binds
    abstract fun bindPhoneDetailsRepository(phoneDetailsRepositoryImpl: PhoneDetailsRepositoryImpl) : PhoneDetailsRepository

    @Binds
    abstract fun bindPhoneRepository(phoneRepositoryImpl: PhoneRepositoryImpl) : PhoneRepository
}