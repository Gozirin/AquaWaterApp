package com.decagon.aqua.core.di

import com.decagon.aqua.core.api.AquaApi
import com.decagon.aqua.feature.consumer.authentication.AquaRepositoryInterface
import com.decagon.aqua.feature.consumer.authentication.AquaRepositoryInterfaceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAquaRepository(aquaApi: AquaApi): AquaRepositoryInterfaceImpl {
        return AquaRepositoryInterfaceImpl(aquaApi)
    }
    @Singleton
    @Provides
    fun provideAquaRepositoryInterface(aquaApi: AquaApi): AquaRepositoryInterface {
        return AquaRepositoryInterfaceImpl(aquaApi)
    }
}
