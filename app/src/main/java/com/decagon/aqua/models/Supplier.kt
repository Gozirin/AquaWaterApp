package com.decagon.aqua.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "suppliers"
)
data class Supplier(
    @PrimaryKey(autoGenerate = true)
    var supplierID: Int,
    val companyId: String,
    val user: UserX
) : Serializable
