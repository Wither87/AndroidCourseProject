package com.example.data.type_converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PhoneImagesConverter {
    private val gson = Gson()

    @TypeConverter
    fun stringToStringList(data: String) : List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun stringsListToString(stringsList: List<String>) : String{
        return gson.toJson(stringsList)
    }
}