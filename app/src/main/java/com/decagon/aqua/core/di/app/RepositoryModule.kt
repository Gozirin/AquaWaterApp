package com.decagon.aqua.core.di.app

import com.decagon.aqua.network.AquaApi
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
    fun provideAuthRepository(aquaApi: AquaApi): AuthRepository {
        return AuthRepository(aquaApi)
    }

    @Singleton
    @Provides
    fun provideAuthRepoInterface(aquaApi: AquaApi): AuthRepositoryInterface =
        AuthRepository(aquaApi)
}
