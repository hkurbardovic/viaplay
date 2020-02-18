package com.hkurbardovic.viaplay.di.modules

import android.content.Context
import com.hkurbardovic.viaplay.app.ViaplayApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule {

    @Provides
    @Singleton
    fun provideContext(application: ViaplayApp): Context {
        return application.applicationContext
    }
}