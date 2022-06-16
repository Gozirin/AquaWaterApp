package com.decagon.aqua.repositories

import com.decagon.aqua.commons.Resource
import com.decagon.aqua.models.consumerAuthModule.consumerhomepage.AllCompaniesWithFeaturedProduct

interface IConsumerRepository {

    // get company products for consumer homepage
    suspend fun getCompaniesProducts(): Resource<AllCompaniesWithFeaturedProduct>
}