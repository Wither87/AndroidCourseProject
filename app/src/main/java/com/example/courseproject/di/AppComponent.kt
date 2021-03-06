package com.example.courseproject.di

import com.example.courseproject.MainActivity
import com.example.courseproject.ui.home.HomeFragment
import com.example.courseproject.ui.phone.PhoneFragment
import com.example.courseproject.ui.phonedetails.PhoneDetailsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(HomeFragment: HomeFragment)
    fun inject(phoneFragment: PhoneFragment)
    fun inject(phoneDetailsFragment: PhoneDetailsFragment)
}