package com.example.courseproject

import android.app.Application
import android.content.Context
import com.example.courseproject.di.AppComponent
import com.example.courseproject.di.AppModule
import com.example.courseproject.di.DaggerAppComponent

class MainApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> applicationContext.appComponent
    }