package com.hkurbardovic.viaplay.main.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hkurbardovic.viaplay.main.repositories.SectionsRepository
import javax.inject.Inject

/**
 * Factory for creating a [SectionsViewModel] with a constructor that takes a [SectionsRepository].
 */
class SectionsViewModelFactory @Inject constructor(
    private val repository: SectionsRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        SectionsViewModel(repository) as T
}