package com.decagon.aqua.core.di.app

import android.content.Context
import androidx.room.Room
import com.decagon.aqua.api.AquaApi
import com.decagon.aqua.core.data.AquaDatabase
import com.decagon.aqua.feature.consumer.authentication.AquaRepositoryInterface
import com.decagon.aqua.feature.consumer.authentication.AquaRepositoryInterfaceImpl
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
object AppModule {

    private const val BASE_URL = "https://aquawaterapp.herokuapp.com"
    @Provides
    @Singleton
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }
    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }
    @Provides
    @Singleton
    fun provideConverterFactory(): GsonConverterFactory{
        return GsonConverterFactory.create()
    }
    @Provides
    @Singleton
    fun provideRetrofitInstance(converterFactory: GsonConverterFactory, okHttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideAquaApi(retrofit: Retrofit): AquaApi {
        return retrofit.create(AquaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(aquaApi: AquaApi): AquaRepositoryInterface {
        return AquaRepositoryInterfaceImpl(aquaApi)
    }

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
}