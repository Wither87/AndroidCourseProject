package com.example.courseproject.ui.phone

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Phone
import com.example.domain.usecases.GetPhonesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhoneViewModel @Inject constructor(
    private val getPhonesUseCase: GetPhonesUseCase
): ViewModel() {

    val phonesLiveData = MutableLiveData<List<Phone>>()
    val isLoadedLiveData = MutableLiveData<Boolean>()

    fun loadPhones(brandSlug: String) {
        isLoadedLiveData.postValue(false)

        viewModelScope.launch {
            val brands = getPhonesUseCase.execute(brandSlug)
            phonesLiveData.postValue(brands)
            isLoadedLiveData.postValue(true)
        }
    }
}