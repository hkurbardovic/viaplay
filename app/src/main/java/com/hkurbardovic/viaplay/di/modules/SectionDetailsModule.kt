package com.hkurbardovic.viaplay.di.modules

import com.hkurbardovic.viaplay.di.scopes.FragmentScoped
import com.hkurbardovic.viaplay.main.fragments.SectionDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
@Suppress("UNUSED")
internal abstract class SectionDetailsModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun sectionDetailsFragment(): SectionDetailsFragment
}