package com.decagon.aqua.core.di.app

import android.content.Context
import androidx.room.Room
import com.decagon.aqua.core.data.AquaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

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
