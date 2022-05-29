package com.example.courseproject.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module(includes = [
    DataModule::class,
    DomainModule::class,
    NetworkModule::class,
    ViewModelModule::class,
    DatabaseModule::class,
])
class AppModule(val context: Context){
    @Provides
    fun provideContext(): Context{
        return context
    }
}