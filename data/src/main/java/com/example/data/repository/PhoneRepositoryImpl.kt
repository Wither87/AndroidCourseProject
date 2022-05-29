package com.example.data.repository

import android.util.Log
import com.example.data.api.RetrofitService
import com.example.data.models.Phone
import com.example.domain.models.Phone as DomainPhone
import com.example.domain.repository.PhoneRepository
import javax.inject.Inject
import com.example.data.models.mapToDomain
import com.example.data.storage.BrandDao
import com.example.data.storage.PhoneDao
import java.lang.Exception

class PhoneRepositoryImpl @Inject constructor(
    private val service: RetrofitService,
    private val brandDao: BrandDao,
    private val phoneDao: PhoneDao
) : PhoneRepository{
    override suspend fun getPhonesList(brandSlug: String): List<DomainPhone> {
        try{
            var currentPage = 1
            var lastPage = 1
            val phones = mutableListOf<DomainPhone>()
            do {
                val response = service.getPage(brandSlug, currentPage)
                if (response.status){
                    lastPage = response.data.Last_page
                    currentPage++

                    for (phone in response.data.Phones){
                        Log.i("phload", phone.Phone_name!!+' '+phone.Brand)
                        if (phoneDao.findByName(phone.Phone_name) == null){
                            phoneDao.insertOne(phone)
                        }
                        phones.add(phone.mapToDomain())
                    }
                }
            }while(currentPage < lastPage)
            return phones.toList()
        }
        catch (e: Exception){
            Log.e("phonesload",e.toString())
            val brand = brandDao.findByBrandSlug(brandSlug)
            val phones = phoneDao.findAllByBrandName(brand?.Brand_name+' ')
            return mapToDomain(phones)
        }
        return listOf()
    }

    private fun mapToDomain(list: List<Phone>): List<DomainPhone>{
        val phones = mutableListOf<DomainPhone>()
        for(phone in list){
            val p = phone.mapToDomain()
            phones.add(p)
        }
        return phones
    }
}