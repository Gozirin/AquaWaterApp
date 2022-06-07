package com.decagon.aqua.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.decagon.aqua.models.consumerAuthModule.User
import java.io.Serializable

@Entity(
    tableName = "consumers"
)
data class Consumer(
    @PrimaryKey(autoGenerate = true)
    var consumerID: Int,
    val consumptionLevel: Int,
    val earnedCash: Int,
    val user: User
) : Serializable
