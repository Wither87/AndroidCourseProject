package com.example.courseproject.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.courseproject.ViewModelFactory
import com.example.courseproject.ViewModelKey
import com.example.courseproject.ui.home.HomeViewModel
import com.example.courseproject.ui.phone.PhoneViewModel
import com.example.courseproject.ui.phonedetails.PhoneDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun homeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PhoneViewModel::class)
    abstract fun phoneViewModel(viewModel: PhoneViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PhoneDetailsViewModel::class)
    abstract fun phoneDetailsViewModel(viewModel: PhoneDetailsViewModel): ViewModel
}
