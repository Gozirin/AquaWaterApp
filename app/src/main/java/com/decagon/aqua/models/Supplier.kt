package com.decagon.aqua.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "suppliers"
)
data class Supplier(
    @PrimaryKey(autoGenerate = true)
    var supplierID: Int,
    val businessEmail: String,
    val businessPhoneNumber: String,
    val companyId: String,
    val user: UserX
)
