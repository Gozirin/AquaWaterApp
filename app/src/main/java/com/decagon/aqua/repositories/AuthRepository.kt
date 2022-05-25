package com.decagon.aqua.repositories

import com.decagon.aqua.models.Supplier
import com.decagon.aqua.models.consumerAuthModule.User
import com.decagon.aqua.models.supplierAuthModule.RegisterResponse
import com.decagon.aqua.network.SupplierAuthApi
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val supplierAuthApi: SupplierAuthApi
) : AuthRepositoryInterface {
    override suspend fun addSupplier(supplier: Supplier): Response<RegisterResponse> {
        return supplierAuthApi.addSuppiler(supplier)
    }

    override suspend fun addConsumer(user: User): Response<RegisterResponse> {
        TODO("Not yet implemented")
    }
}
