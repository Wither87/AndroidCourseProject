package com.example.kourseproject.di

import dagger.Module

@Module(includes = [
    DataModule::class,
    DomainModule::class,
    NetworkModule::class,
    ViewModelModule::class,
])
class AppModule