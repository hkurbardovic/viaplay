package com.hkurbardovic.viaplay.di.modules

import androidx.lifecycle.ViewModel
import com.hkurbardovic.viaplay.di.scopes.FragmentScoped
import com.hkurbardovic.viaplay.di.scopes.ViewModelKey
import com.hkurbardovic.viaplay.main.fragments.SectionDetailsFragment
import com.hkurbardovic.viaplay.main.viewmodels.SectionDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class SectionDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun sectionDetailsFragment(): SectionDetailsFragment

    @Binds
    @IntoMap
    @ViewModelKey(SectionDetailsViewModel::class)
    internal abstract fun bindSectionDetailsViewModel(viewModel: SectionDetailsViewModel): ViewModel
}