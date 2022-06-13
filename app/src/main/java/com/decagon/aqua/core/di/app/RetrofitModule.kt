package com.decagon.aqua.core.di.app

import com.decagon.aqua.commons.BASE_URL
import com.decagon.aqua.core.service.ForgotResetPassWordAPI
import com.decagon.aqua.feature.onboarding.ResetPasswordRepository
import com.decagon.aqua.feature.repository.ForgotPasswordRepository
import com.decagon.aqua.feature.repository.IForgotPasswordRepository
import com.decagon.aqua.feature.repository.IResetPasswordRepositoryInterface
import com.decagon.aqua.models.Util.ApiService
import com.decagon.aqua.models.repository.IUpdatePasswordRepository
import com.decagon.aqua.models.repository.UpdatePasswordRepository
import com.decagon.aqua.network.SupplierAuthApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideSupplierAuthApi(): SupplierAuthApi {
        return provideRetrofitInstance().create(SupplierAuthApi::class.java)
    }

    @Singleton
    @Provides
    fun provideUpdatePasswordApiService(): ApiService {
        return provideRetrofitInstance().create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideForgotPasswordResetApiService(): ForgotResetPassWordAPI {
        return provideRetrofitInstance().create(ForgotResetPassWordAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideResetPasswordRepository(forgotResetPassWordAPI: ForgotResetPassWordAPI): IResetPasswordRepositoryInterface {
        return ResetPasswordRepository(forgotResetPassWordAPI)
    }

    @Singleton
    @Provides
    fun providesForgetPasswordRepository(forgotResetPassWordAPI: ForgotResetPassWordAPI): IForgotPasswordRepository {
        return ForgotPasswordRepository(forgotResetPassWordAPI)
    }

    @Singleton
    @Provides
    fun provideUpdatePasswordRepository(apiService: ApiService): IUpdatePasswordRepository {
        return UpdatePasswordRepository(apiService)
    }
}
