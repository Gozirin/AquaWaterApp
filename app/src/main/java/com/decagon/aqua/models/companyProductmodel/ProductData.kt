package com.decagon.aqua.models.companyProductmodel

data class ProductData(
    val id: String,
    val inStock: Boolean,
    val name: String,
    val noOfRating: Int,
    val photos: List<Photo>,
    val price: Double,
    val quantityAvailable: Int,
    val rating: Int
)
