package com.example.data.repository

import com.example.data.api.RetrofitService
import com.example.data.models.mapToData
import com.example.domain.models.PhoneDetails
import com.example.domain.repository.PhoneDetailsRepository
import javax.inject.Inject
import com.example.data.models.mapToDomain
import com.example.data.storage.PhoneDao
import com.example.data.storage.PhoneDetailsDao
import com.example.domain.models.Phone
import com.example.domain.models.Specifications
import com.example.domain.models.Specs

class PhoneDetailsRepositoryImpl @Inject constructor(
    private val service: RetrofitService,
    private val phoneDao: PhoneDao,
    private val phoneDetailsDao: PhoneDetailsDao
) : PhoneDetailsRepository {
    override suspend fun getPhoneDetails(phoneSlug: String): PhoneDetails? {
        try{
            val response = service.getPhoneDetails(phoneSlug)
            if (response.status) {
                if (phoneDetailsDao.findByName(response.data.Phone_name!!) == null){
                    phoneDetailsDao.insertOne(response.data)
                }
                return response.data.mapToDomain()
            }
        }
        catch (e: Exception){
            val phone = phoneDao.findBySlug(phoneSlug)
            val details = phoneDetailsDao.findByName(phone?.Phone_name!!)
                ?: return PhoneDetails.nullObject()
            return details.mapToDomain()
        }
        return PhoneDetails.nullObject()
    }
}