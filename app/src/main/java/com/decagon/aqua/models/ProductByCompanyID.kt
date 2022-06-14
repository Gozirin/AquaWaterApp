package com.decagon.aqua.models
data class ProductByCompanyID(
    var companyId: String,
    var companyName: String,
    var rating: Int,
    var inStock: Boolean,
    var price: Int
)
