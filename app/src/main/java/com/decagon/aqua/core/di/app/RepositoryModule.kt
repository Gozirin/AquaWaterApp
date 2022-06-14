package com.decagon.aqua.core.di.app

import com.decagon.aqua.network.AuthenticationApi
import com.decagon.aqua.repositories.AuthRepository
import com.decagon.aqua.repositories.AuthRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideAuthRepository(supplierAuthApi: AuthenticationApi): AuthRepository {
        return AuthRepository(supplierAuthApi)
    }

    @Singleton
    @Provides
    fun provideAuthRepoInterface(authenticationApi: AuthenticationApi): AuthRepositoryInterface =
        AuthRepository(authenticationApi)
}
