package com.example.data.repository

import com.example.data.api.RetrofitService
import com.example.domain.models.Phone
import com.example.domain.repository.PhoneRepository
import javax.inject.Inject

class PhoneRepositoryImpl @Inject constructor(
    val service: RetrofitService
) : PhoneRepository{
    override suspend fun getPhonesList(brandSlug: String): List<Phone> {
        var currentPage = 1
        var lastPage = 1
        val phones = mutableListOf<Phone>()
        do {
            val response = service.getPage(brandSlug, currentPage)
            if (response.status){
                lastPage = response.data.Last_page
                currentPage++

                for (phone in response.data.Phones){
                    phones.add(phone.mapToDomain())
                }
            }
        }while(currentPage < lastPage)
        return phones.toList()
    }
}