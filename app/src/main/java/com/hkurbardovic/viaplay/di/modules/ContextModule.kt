package com.hkurbardovic.viaplay.di.modules

import android.content.Context
import com.hkurbardovic.viaplay.app.ViaplayApp
import dagger.Module
import dagger.Provides

@Module
class ContextModule {

    @Provides
    fun provideContext(application: ViaplayApp): Context {
        return application.applicationContext
    }
}