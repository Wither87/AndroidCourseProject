package com.example.courseproject.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Brand
import com.example.domain.models.Phone
import com.example.domain.models.PhoneDetails
import com.example.domain.usecases.GetBrandsListUseCase
import com.example.domain.usecases.GetPhoneDetailsUseCase
import com.example.domain.usecases.GetPhonesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getBrandsUseCase: GetBrandsListUseCase,
    private val getPhonesUseCase: GetPhonesUseCase,
    private val getPhoneDetailsUseCase: GetPhoneDetailsUseCase,
) : ViewModel() {

    val brandsLiveData = MutableLiveData<List<Brand>>()
    val phonesLiveData = MutableLiveData<List<Phone>>()
    val phoneDetailsLiveData = MutableLiveData<PhoneDetails>()

    fun loadBrands() {
        viewModelScope.launch {
            val brands = getBrandsUseCase.execute()
            brandsLiveData.postValue(brands)
        }

    }

    fun loadPhones(brandsSlug: String) {
        viewModelScope.launch {
            val phones = getPhonesUseCase.execute(brandsSlug)
            phonesLiveData.postValue(phones)
        }
    }

    fun loadPhoneDetails(phoneSlug: String){
        viewModelScope.launch {
            val phoneDetails = getPhoneDetailsUseCase.execute(phoneSlug)
            phoneDetailsLiveData.postValue(phoneDetails)
        }
    }
}