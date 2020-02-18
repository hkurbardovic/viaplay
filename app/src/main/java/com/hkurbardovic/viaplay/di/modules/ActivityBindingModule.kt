package com.hkurbardovic.viaplay.di.modules

import com.hkurbardovic.viaplay.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [SectionsModule::class, SectionDetailsModule::class])
    internal abstract fun mainActivity(): MainActivity
}