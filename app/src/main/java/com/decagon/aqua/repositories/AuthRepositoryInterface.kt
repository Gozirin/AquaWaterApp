package com.decagon.aqua.repositories

import com.decagon.aqua.commons.Resource
import com.decagon.aqua.core.data.UserSignUpResponse
import com.decagon.aqua.models.Consumer
import com.decagon.aqua.models.Supplier
import com.decagon.aqua.models.consumerAuthModule.getcompanieswithfeaturedproduct.AllCompaniesWithFeaturedProduct
import com.decagon.aqua.models.supplierAuthModule.* // ktlint-disable no-wildcard-imports

interface AuthRepositoryInterface {
    suspend fun addSupplier(supplier: Supplier): Resource<RegisterResponse>
    suspend fun getCompanies(): Resource<CompanyList>
    suspend fun confirmEmail(confirmEmailModel: ConfirmEmailModel): Resource<RegisterResponse>
    suspend fun loginUser(loginModel: LoginModel): Resource<LoginResponse>
    suspend fun addConsumer(signUpRequest: Consumer): Resource<UserSignUpResponse>

    // get company products for consumer homepage
    suspend fun getCompaniesProducts(): Resource<AllCompaniesWithFeaturedProduct>
}
