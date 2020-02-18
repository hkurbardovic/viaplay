package com.hkurbardovic.viaplay.main.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hkurbardovic.viaplay.main.repositories.SectionsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SectionDetailsViewModel @Inject constructor(private val repository: SectionsRepository) :
    ViewModel() {

    val sectionDetailsLiveData = repository.sectionDetailsLiveData

    val errorMessageLiveData = repository.errorMessageLiveData

    val isLoadingLiveData = repository.isLoadingLiveData

    fun getSectionDetails(href: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getSectionDetails(href)
        }
    }

    fun postSectionIdValue(id: String) {
        repository.postSectionIdValue(id)
    }
}