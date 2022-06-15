package com.decagon.aqua.repositories

import com.decagon.aqua.commons.Resource
import com.decagon.aqua.core.data.UserSignUpResponse
import com.decagon.aqua.models.Consumer
import com.decagon.aqua.models.Supplier
import com.decagon.aqua.models.consumerAuthModule.consumerhomepage.AllCompaniesWithFeaturedProduct
import com.decagon.aqua.models.supplierAuthModule.* // ktlint-disable no-wildcard-imports
import com.decagon.aqua.network.AquaApi
import javax.inject.Inject

class AuthRepository @Inject constructor(

    private val aquaApi: AquaApi
) : AuthRepositoryInterface, BaseRepository() {

    override suspend fun addSupplier(supplier: Supplier): Resource<RegisterResponse> {
        return try {
            safeApiCall { aquaApi.addSuppiler(supplier) }
        } catch (e: Exception) {
            Resource.Error(e.printStackTrace().toString())
        }
    }

    override suspend fun getCompanies(): Resource<CompanyList> {
        return safeApiCall { aquaApi.getCompanies() }
    }

    override suspend fun confirmEmail(confirmEmailModel: ConfirmEmailModel): Resource<RegisterResponse> {
        return try {
            safeApiCall { aquaApi.confirmEmail(confirmEmailModel) }
        } catch (e: Exception) {
            Resource.Error(e.printStackTrace().toString())
        }
    }

    override suspend fun loginUser(loginModel: LoginModel): Resource<LoginResponse> {
        return try {
            safeApiCall { aquaApi.logIn(loginModel) }
        } catch (e: Exception) {
            Resource.Error(e.printStackTrace().toString())
        }
    }

    override suspend fun addConsumer(signUpRequest: Consumer): Resource<UserSignUpResponse> {
        return try {
            safeApiCall { aquaApi.consumerSignUp(signUpRequest) }
        } catch (e: Exception) {
            Resource.Error(e.printStackTrace().toString())
        }
    }

    override suspend fun getCompaniesProducts(): Resource<AllCompaniesWithFeaturedProduct> {
       return safeApiCall { aquaApi.getCompaniesWithProducts() }
    }
}
