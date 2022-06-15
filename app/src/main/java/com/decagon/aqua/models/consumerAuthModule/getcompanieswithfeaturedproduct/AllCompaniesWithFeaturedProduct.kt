package com.decagon.aqua.models.consumerAuthModule.getcompanieswithfeaturedproduct

data class AllCompaniesWithFeaturedProduct(
    val currentPage: Int,
    val pageItems: List<PageItem>,
    val pageSize: Int,
    val previousPage: Int,
    val totalNumberOfPages: Int
)