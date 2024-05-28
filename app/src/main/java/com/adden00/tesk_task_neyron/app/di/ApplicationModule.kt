package com.adden00.tesk_task_neyron.app.di

import com.adden00.tesk_task_neyron.data.local.UserCache
import com.adden00.tesk_task_neyron.data.local.UserCacheImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Provides
    @Singleton
    fun provideCache(): UserCache {
        return UserCacheImplementation
    }
}