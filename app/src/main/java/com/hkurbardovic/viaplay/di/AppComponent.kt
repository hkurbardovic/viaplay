package com.hkurbardovic.viaplay.di

import com.hkurbardovic.viaplay.app.ViaplayApp
import com.hkurbardovic.viaplay.di.modules.ActivityBindingModule
import com.hkurbardovic.viaplay.di.modules.ContextModule
import com.hkurbardovic.viaplay.di.modules.DatabaseModule
import com.hkurbardovic.viaplay.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ContextModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        ActivityBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<ViaplayApp> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance viaplayApp: ViaplayApp): AppComponent
    }
}