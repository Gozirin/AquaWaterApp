package com.decagon.aqua.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {
    suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): Resource<T> {

        return withContext(Dispatchers.IO) {
            try {
                val response: Response<T> = apiToBeCalled()
                if (response.isSuccessful) {
                    Resource.Success(response.body())
                } else {
                    val errorResponse = response.errorBody()?.charStream()?.readText()
                    Resource.Error(
                        errorMessage = errorResponse.toString()
                    )
                }
            } catch (e: HttpException) {
                Resource.Error(errorMessage = e.message())
            } catch (e: IOException) {
                Resource.Error(errorMessage = "Please check your network connection")
            } catch (e: Exception) {
                Resource.Error(errorMessage = "Something went wrong")
            }
        }
    }
}
