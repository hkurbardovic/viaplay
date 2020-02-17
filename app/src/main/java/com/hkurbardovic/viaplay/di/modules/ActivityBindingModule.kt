package com.hkurbardovic.viaplay.di.modules

import com.hkurbardovic.viaplay.di.scopes.ActivityScoped
import com.hkurbardovic.viaplay.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun activity(): MainActivity
}