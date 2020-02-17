package com.hkurbardovic.viaplay.di.modules

import androidx.lifecycle.ViewModel
import com.hkurbardovic.viaplay.di.scopes.ViewModelKey
import com.hkurbardovic.viaplay.main.viewmodels.SectionsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(SectionsViewModel::class)
    internal abstract fun bindSectionsViewModel(viewModel: SectionsViewModel): ViewModel
}