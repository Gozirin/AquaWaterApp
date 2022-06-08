package com.decagon.aqua.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.decagon.aqua.models.supplierAuthModule.UserX
import java.io.Serializable

@Entity(
    tableName = "suppliers"
)
data class Supplier(
    @PrimaryKey
    val companyId: String,
    val user: UserX
) : Serializable
