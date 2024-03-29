package com.decagon.aqua.core.di.app

import com.decagon.aqua.network.AuthenticationApi // ktlint-disable import-ordering
import com.decagon.aqua.network.ConsumerApi
// import com.decagon.aqua.network.ConsumerApi
import com.decagon.aqua.repositories.AuthRepository
import com.decagon.aqua.repositories.AuthRepositoryInterface
import com.decagon.aqua.repositories.ConsumerRepository
import com.decagon.aqua.repositories.IConsumerRepository
import com.decagon.aqua.repositories.companyproductrepository.CompanyProductRepository
import com.decagon.aqua.repositories.companyproductrepository.ICompanyProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
//
//    @Singleton
//    @Provides
//    fun provideAuthRepository(supplierAuthApi: AuthenticationApi): AuthRepositoryInterface {
//        return AuthRepository(supplierAuthApi)
//    }

    @Singleton
    @Provides
    fun provideAuthRepoInterface(authenticationApi: AuthenticationApi): AuthRepositoryInterface =
        AuthRepository(authenticationApi)

    @Singleton
    @Provides
    fun providesConsumerRepository(consumerApi: ConsumerApi): IConsumerRepository {
        return ConsumerRepository(consumerApi)
    }

    @Singleton
    @Provides
    fun providesCompanyProductRepository(consumerApi: ConsumerApi): ICompanyProductRepository {
        return CompanyProductRepository(consumerApi)
    }
}
