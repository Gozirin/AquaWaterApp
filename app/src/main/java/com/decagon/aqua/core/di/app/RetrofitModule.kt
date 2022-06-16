package com.decagon.aqua.core.di.app

import android.content.Context
import com.decagon.aqua.commons.BASE_URL
import com.decagon.aqua.core.data.sharedpreference.AquaPreferences
import com.decagon.aqua.core.data.sharedpreference.Preference
import com.decagon.aqua.feature.onboarding.ResetPasswordRepository
import com.decagon.aqua.network.ApiService
import com.decagon.aqua.network.AuthenticationApi
import com.decagon.aqua.network.CompanyProductApi
import com.decagon.aqua.network.ForgotResetPassWordAPI
import com.decagon.aqua.repositories.ForgotPasswordRepository
import com.decagon.aqua.repositories.IForgotPasswordRepository
import com.decagon.aqua.repositories.IResetPasswordRepositoryInterface
import com.decagon.aqua.repositories.IUpdatePasswordRepository
import com.decagon.aqua.repositories.UpdatePasswordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideSupplierAuthApi(): AuthenticationApi {
        return provideRetrofitInstance().create(AuthenticationApi::class.java)
    }

    @Singleton
    @Provides
    fun provideUpdatePasswordApiService(): ApiService {
        return provideRetrofitInstance().create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesCompanyProductApiServcie(): CompanyProductApi {
        return provideRetrofitInstance().create(CompanyProductApi::class.java)
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

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): Preference {
        return AquaPreferences(context)
    }
//
//    @Singleton
//    @Provides
//    fun provideConsumerApi(): ConsumerApi {
//        return provideRetrofitInstance().create(ConsumerApi::class.java)
//    }
}
