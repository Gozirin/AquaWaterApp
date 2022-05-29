package com.decagon.aqua.commons

import androidx.room.TypeConverter
import com.decagon.aqua.models.Location
import com.decagon.aqua.models.LocationX
import com.decagon.aqua.models.consumerAuthModule.User
import com.decagon.aqua.models.supplierAuthModule.Data
import com.decagon.aqua.models.supplierAuthModule.UserX
import com.google.gson.Gson

class Converter {

    @TypeConverter
    fun fromUserToJsonString(value: User): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToUser(value: String): User =
        Gson().fromJson(value, User::class.java)

    @TypeConverter
    fun fromUserXToJsonString(value: UserX): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToUserX(value: String): UserX =
        Gson().fromJson(value, UserX::class.java)

    @TypeConverter
    fun fromLocationToJsonString(value: Location): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToLocation(value: String): Location =
        Gson().fromJson(value, Location::class.java)

    @TypeConverter
    fun fromLocationXToJsonString(value: LocationX): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToLocationX(value: String): LocationX =
        Gson().fromJson(value, LocationX::class.java)

    @TypeConverter
    fun fromDataToJsonString(value: Data): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToData(value: String): Data =
        Gson().fromJson(value, Data::class.java)
}
