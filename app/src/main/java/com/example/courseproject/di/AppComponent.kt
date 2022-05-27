package com.example.courseproject.di

import com.example.courseproject.MainActivity
import com.example.courseproject.ui.main.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(mainFragment: MainFragment)
}