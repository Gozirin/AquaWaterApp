package com.decagon.aqua.models.consumerAuthModule.getcompanieswithfeaturedproduct

data class PageItem(
    val companyName: String,
    val location: Location,
    val product: Product? = null
)
