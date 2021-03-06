package com.hkurbardovic.viaplay.main.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hkurbardovic.viaplay.main.repositories.SectionsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SectionsViewModel @Inject constructor(private val repository: SectionsRepository) :
    ViewModel() {

    val sectionsLiveData = repository.sectionsLiveData

    val errorMessageLiveData = repository.errorMessageLiveData

    val isLoadingLiveData = repository.isLoadingLiveData

    fun getSections() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getSections()
        }
    }
}