package com.hkurbardovic.viaplay.di.modules

import android.content.Context
import com.hkurbardovic.viaplay.database.ViaplayDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class DatabaseModule {

    @Provides
    @Singleton
    fun database(context: Context): ViaplayDatabase {
        return ViaplayDatabase.getInstance(context)
    }
}