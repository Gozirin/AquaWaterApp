package com.decagon.aqua.core.di.app

import com.decagon.aqua.network.AuthenticationApi
import com.decagon.aqua.network.CompanyProductApi
import com.decagon.aqua.repositories.AuthRepository
import com.decagon.aqua.repositories.AuthRepositoryInterface
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

    @Singleton
    @Provides
    fun provideAuthRepository(supplierAuthApi: AuthenticationApi): AuthRepository {
        return AuthRepository(supplierAuthApi)
    }

    @Singleton
    @Provides
    fun provideAuthRepoInterface(authenticationApi: AuthenticationApi): AuthRepositoryInterface =
        AuthRepository(authenticationApi)
    @Singleton
    @Provides
    fun providesCompanyRepository(companyProductApi: CompanyProductApi): ICompanyProductRepository{
        return CompanyProductRepository(companyProductApi)
    }
}
