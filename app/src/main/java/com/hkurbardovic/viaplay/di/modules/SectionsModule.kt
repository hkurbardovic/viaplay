package com.hkurbardovic.viaplay.di.modules

import com.hkurbardovic.viaplay.di.scopes.FragmentScoped
import com.hkurbardovic.viaplay.main.fragments.SectionsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
@Suppress("UNUSED")
internal abstract class SectionsModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun sectionsFragment(): SectionsFragment
}