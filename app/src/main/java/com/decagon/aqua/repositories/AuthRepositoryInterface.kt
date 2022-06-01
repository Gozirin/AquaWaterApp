package com.decagon.aqua.repositories

import com.decagon.aqua.models.Supplier
import com.decagon.aqua.models.supplierAuthModule.* // ktlint-disable no-wildcard-imports
import retrofit2.Response

interface AuthRepositoryInterface {
    suspend fun addSupplier(supplier: Supplier): Response<RegisterResponse>
    suspend fun getCompanies(): Response<CompanyList>
    suspend fun confirmEmail(confirmEmailModel: ConfirmEmailModel): Response<RegisterResponse>
    suspend fun loginUser(loginModel: LoginModel): Response<LoginResponse>
}
