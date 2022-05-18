package com.decagon.aqua.core.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.decagon.aqua.models.Consumer

@Dao
interface AquaConsumerDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun registerConsumer(consumer: Consumer)

    @Delete
    suspend fun deleteConsumer(consumer: Consumer)
}
