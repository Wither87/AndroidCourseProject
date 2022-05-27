package com.example.courseproject.di

import com.example.courseproject.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}