package com.decagon.aqua.models.companyProductmodel

data class CompanyProductResponse(
    val currentPage: Int,
    val pageItems: List<ProductData>,
    val pageSize: Int,
    val previousPage: Int,
    val totalNumberOfPages: Int
)