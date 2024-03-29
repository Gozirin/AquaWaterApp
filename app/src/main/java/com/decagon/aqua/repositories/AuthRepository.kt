package com.decagon.aqua.repositories

import com.decagon.aqua.commons.Resource
import com.decagon.aqua.models.Consumer
import com.decagon.aqua.models.Supplier
import com.decagon.aqua.models.UserSignUpResponse
import com.decagon.aqua.models.supplierAuthModule.* // ktlint-disable no-wildcard-imports
import com.decagon.aqua.network.AuthenticationApi
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val supplierAuthApi: AuthenticationApi
) : AuthRepositoryInterface, BaseRepository() {

    override suspend fun addSupplier(supplier: Supplier): Resource<RegisterResponse> {
        return try {
            safeApiCall { supplierAuthApi.addSuppiler(supplier) }
        } catch (e: Exception) {
            Resource.Error(e.printStackTrace().toString())
        }
    }

    override suspend fun getCompanies(): Resource<CompanyList> {
        return safeApiCall { supplierAuthApi.getCompanies() }
    }

    override suspend fun confirmEmail(confirmEmailModel: ConfirmEmailModel): Resource<RegisterResponse> {
        return try {
            safeApiCall { supplierAuthApi.confirmEmail(confirmEmailModel) }
        } catch (e: Exception) {
            Resource.Error(e.printStackTrace().toString())
        }
    }

    override suspend fun loginUser(loginModel: LoginModel): Resource<LoginResponse> {
        return try {
            safeApiCall { supplierAuthApi.logIn(loginModel) }
        } catch (e: Exception) {
            Resource.Error(e.printStackTrace().toString())
        }
    }

    override suspend fun addConsumer(signUpRequest: Consumer): Resource<UserSignUpResponse> {
        return try {
            safeApiCall { supplierAuthApi.consumerSignUp(signUpRequest) }
        } catch (e: Exception) {
            Resource.Error(e.printStackTrace().toString())
        }
    }
}
