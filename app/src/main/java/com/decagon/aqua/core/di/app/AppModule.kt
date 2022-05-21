package com.decagon.aqua.core.di.app

import android.content.Context
import androidx.room.Room
import com.decagon.aqua.core.api.AquaApi
import com.decagon.aqua.core.data.AquaDatabase
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

    @Singleton
    @Provides
    fun getRetroClientInstance(): AquaApi {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(interceptor).build())
            .build()
            .create(AquaApi::class.java)
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
