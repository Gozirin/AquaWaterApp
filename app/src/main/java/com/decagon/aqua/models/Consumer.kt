package com.decagon.aqua.models

data class Consumer(
    val consumptionLevel: Int,
    val earnedCash: Int,
    val user: User
)
