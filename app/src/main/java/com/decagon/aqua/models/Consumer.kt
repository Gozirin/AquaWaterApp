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
    var consumerID: Int? = null,
    val consumptionLevel: Int? = 0,
    val earnedCash: Double? = 0.0,
    val user: User,
    val profilePictureUrl: String? = null
) : Serializable
