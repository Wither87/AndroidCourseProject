package com.example.courseproject.ui.phonedetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.PhoneDetails
import com.example.domain.usecases.GetPhoneDetailsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhoneDetailsViewModel @Inject constructor(
    private val getPhoneDetailsUseCase: GetPhoneDetailsUseCase
) : ViewModel() {

    val phoneDetailsLiveData = MutableLiveData<PhoneDetails>()

    fun loadPhoneDetails(phoneSlug: String) {
        viewModelScope.launch {
            val details = getPhoneDetailsUseCase.execute(phoneSlug)
            phoneDetailsLiveData.postValue(details)
        }
    }
}