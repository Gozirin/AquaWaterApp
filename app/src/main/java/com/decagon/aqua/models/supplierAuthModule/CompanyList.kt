package com.decagon.aqua.models.supplierAuthModule

import java.io.Serializable

data class CompanyList(
    val `data`: List<Data>,
    val errors: Any,
    val message: String,
    val success: Boolean
) : Serializable
