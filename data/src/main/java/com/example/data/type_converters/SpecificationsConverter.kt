package com.example.data.type_converters

import androidx.room.TypeConverter
import com.example.data.models.Specifications
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SpecificationsConverter {
    private val gson = Gson()

    @TypeConverter
    fun stringToSpecificationsList(data: String) : List<Specifications> {
        val type = object : TypeToken<List<Specifications>>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun specificationsListToString(specificationsList: List<Specifications>) : String{
        return gson.toJson(specificationsList)
    }
}