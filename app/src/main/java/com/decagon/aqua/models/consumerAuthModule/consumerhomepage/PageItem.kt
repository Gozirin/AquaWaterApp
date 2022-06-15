package com.decagon.aqua.models.consumerAuthModule.consumerhomepage

data class PageItem(
    val companyName: String,
    val location: Location,
    val product: Product? = null
)