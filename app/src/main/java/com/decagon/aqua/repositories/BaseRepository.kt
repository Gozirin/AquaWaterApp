package com.decagon.aqua.repositories

import com.decagon.aqua.commons.Resource
import com.decagon.aqua.models.supplierAuthModule.RegisterResponse
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

// sample1
abstract class BaseRepository {

    suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): Resource<T> {

        return withContext(Dispatchers.IO) {
            try {
                val response: Response<T> = apiToBeCalled()
                if (response.isSuccessful) {
                    Resource.Success(data = response.body()!!)
                } else {
                    val errorResponse = convertErrorBody(response.errorBody())
                    Resource.Error(
                        errorMessage = errorResponse?.toString() ?: "Unsuccessful. Try again"
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

    private fun convertErrorBody(errorBody: ResponseBody?): RegisterResponse? {
        return try {
            errorBody?.source()?.let {
                val moshiAdapter = Moshi.Builder().build().adapter(RegisterResponse::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (e: Exception) {
            null
        }
    }
}
