package com.decagon.aqua.core.data // package com.decagon.aqua.core

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.decagon.aqua.commons.Converter
import com.decagon.aqua.models.Consumer
import com.decagon.aqua.models.Supplier

@Database(entities = [Consumer::class, Supplier::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AquaDatabase : RoomDatabase() {

    abstract fun getAquaConsumerDao(): AquaConsumerDAO
    abstract fun getAquaSupplierDao(): AquaSupplierDAO
}
