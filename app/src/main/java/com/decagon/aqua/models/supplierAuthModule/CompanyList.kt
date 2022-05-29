package com.decagon.aqua.models.supplierAuthModule

data class CompanyList(
    val `data`: List<Data>,
    val errors: Any,
    val message: String,
    val success: Boolean
)
