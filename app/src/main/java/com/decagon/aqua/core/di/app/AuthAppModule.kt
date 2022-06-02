package com.decagon.aqua.core.di.app

import android.content.Context
import androidx.room.Room
import com.decagon.aqua.core.data.AquaDatabase
import com.decagon.aqua.core.service.ApiService
import com.decagon.aqua.feature.onboarding.ResetPasswordRepository
import com.decagon.aqua.feature.repository.IResetPasswordRepositoryInterface
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
object AuthAppModule {

    val BASE_URL = "https://aquawaterapp.herokuapp.com"

    @Singleton
    @Provides
    fun provideAquaDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        AquaDatabase::class.java,
        "aqua.db"
    ).fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideAquaConsumerDao(db: AquaDatabase) = db.getAquaConsumerDao()

    @Singleton
    @Provides
    fun provideAquaSupplierDao(db: AquaDatabase) = db.getAquaSupplierDao()

    @Singleton
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }
    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
    @Singleton
    @Provides
    fun provideRetrofitInstance(
        converterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideResetPasswordRepository(apiService: ApiService): IResetPasswordRepositoryInterface {
        return ResetPasswordRepository(apiService)
    }
}
