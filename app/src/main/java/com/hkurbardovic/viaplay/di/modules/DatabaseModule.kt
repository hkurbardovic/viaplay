package com.hkurbardovic.viaplay.di.modules

import com.hkurbardovic.viaplay.app.ViaplayApp
import com.hkurbardovic.viaplay.database.ViaplayDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun database(application: ViaplayApp): ViaplayDatabase {
        return ViaplayDatabase.getInstance(application)
    }
}