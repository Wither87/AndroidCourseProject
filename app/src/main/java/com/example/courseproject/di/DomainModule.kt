package com.example.courseproject.di

import com.example.domain.usecases.*
import dagger.Binds
import dagger.Module

@Module
abstract class DomainModule {

    @Binds
    abstract fun bindGetBrandsListUseCase(getBrandsListUseCaseImpl: GetBrandsListUseCaseImpl) : GetBrandsListUseCase

    @Binds
    abstract fun bindGetPhoneDetailsUseCase(getPhoneDetailsUseCaseImpl: GetPhoneDetailsUseCaseImpl) : GetPhoneDetailsUseCase

    @Binds
    abstract fun bindGetPhonesUseCase(getPhonesUseCaseImpl: GetPhonesUseCaseImpl) : GetPhonesUseCase
}