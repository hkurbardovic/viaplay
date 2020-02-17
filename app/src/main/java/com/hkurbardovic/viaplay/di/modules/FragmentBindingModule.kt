package com.hkurbardovic.viaplay.di.modules

import com.hkurbardovic.viaplay.di.scopes.FragmentScoped
import com.hkurbardovic.viaplay.main.fragments.SectionsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentBindingModule {
    @FragmentScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun fragment(): SectionsFragment
}