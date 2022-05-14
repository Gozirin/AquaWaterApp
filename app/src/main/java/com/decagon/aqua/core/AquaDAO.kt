package com.decagon.aqua.core

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.decagon.aqua.models.User
import com.decagon.aqua.models.UserX

@Dao
interface AquaDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun registerConsumer(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun registerSupplier(userX: UserX)

    @Delete
    suspend fun deleteConsumer(user: User)

    @Delete
    suspend fun deleteSupplier(userX: UserX)
}
