package com.example.courseproject.di

import com.example.courseproject.MainActivity
import com.example.courseproject.ui.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(HomeFragment: HomeFragment)
}