package com.example.onboardtask.di

import android.content.Context
import com.example.onboardtask.data.local.preferences.PreferencesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Singleton
    @Provides
    fun providePreferencesHelper(@ApplicationContext context: Context) = PreferencesHelper(context)
}