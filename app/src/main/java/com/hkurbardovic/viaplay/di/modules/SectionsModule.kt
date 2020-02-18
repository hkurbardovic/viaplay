package com.hkurbardovic.viaplay.di.modules

import androidx.lifecycle.ViewModel
import com.hkurbardovic.viaplay.di.scopes.FragmentScoped
import com.hkurbardovic.viaplay.di.scopes.ViewModelKey
import com.hkurbardovic.viaplay.main.fragments.SectionsFragment
import com.hkurbardovic.viaplay.main.viewmodels.SectionsViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class SectionsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun sectionsFragment(): SectionsFragment

    @Binds
    @IntoMap
    @ViewModelKey(SectionsViewModel::class)
    internal abstract fun bindSectionsViewModel(viewModel: SectionsViewModel): ViewModel
}