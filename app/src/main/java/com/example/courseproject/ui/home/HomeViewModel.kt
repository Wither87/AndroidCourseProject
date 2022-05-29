package com.example.courseproject.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Brand
import com.example.domain.usecases.GetBrandsListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getBrandsUseCase: GetBrandsListUseCase,
): ViewModel() {

    val brandsLiveData = MutableLiveData<List<Brand>>()
    val isLoadedLiveData = MutableLiveData<Boolean>()

    fun loadBrands() {
        isLoadedLiveData.postValue(false)

        viewModelScope.launch {
            val brands = getBrandsUseCase.execute()
            brandsLiveData.postValue(brands)
            isLoadedLiveData.postValue(true)
        }
    }
}