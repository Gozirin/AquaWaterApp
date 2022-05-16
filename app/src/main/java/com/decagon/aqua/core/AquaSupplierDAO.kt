package com.decagon.aqua.core // package com.decagon.aqua.core

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.decagon.aqua.models.Supplier

@Dao
interface AquaSupplierDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun registerSupplier(supplier: Supplier)

    @Delete
    suspend fun deleteSupplier(supplier: Supplier)
}
