package com.decagon.aqua.models.consumerAuthModule.consumerhomepage

data class Product(
    val additionalInformation: Any,
    val description: String,
    val id: String,
    val inStock: Boolean,
    val name: String,
    val photos: List<Photo>,
    val price: Double,
    val quantityAvailable: Int,
    val reviews: List<Any>
)