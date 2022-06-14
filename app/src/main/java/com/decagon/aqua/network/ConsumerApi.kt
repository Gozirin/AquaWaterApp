package com.decagon.aqua.network

import com.decagon.aqua.models.ProductByCompanyID
import retrofit2.Response
import retrofit2.http.GET

interface ConsumerApi {

    @GET("/api/Product/GetProductsByCompanyID")
    suspend fun getProductsByCompanyID(): Response<List<ProductByCompanyID>>
}
