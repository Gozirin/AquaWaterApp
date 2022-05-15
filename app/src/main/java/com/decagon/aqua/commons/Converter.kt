package com.decagon.aqua.commons

import androidx.room.TypeConverter
import com.decagon.aqua.models.Location
import com.decagon.aqua.models.LocationX
import com.decagon.aqua.models.User
import com.decagon.aqua.models.UserX
import com.google.gson.Gson

class Converter {

    @TypeConverter
    fun fromUserToJsonString(value: User): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToUser(value: String) =
        Gson().fromJson(value, User::class.java)

    @TypeConverter
    fun fromUserXToJsonString(value: UserX): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToUserX(value: String) =
        Gson().fromJson(value, UserX::class.java)

    @TypeConverter
    fun fromLocationToJsonString(value: Location): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToLocation(value: String) =
        Gson().fromJson(value, Location::class.java)

    @TypeConverter
    fun fromLocationXToJsonString(value: LocationX): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToLocationX(value: String) =
        Gson().fromJson(value, LocationX::class.java)
}
