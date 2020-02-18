package com.hkurbardovic.viaplay.base

import androidx.lifecycle.MutableLiveData
import com.hkurbardovic.viaplay.utilities.Event

abstract class BaseRepository {

    fun handleException(
        errorMessageMutableLiveData: MutableLiveData<Event<String?>?>,
        errorMessage: String,
        generalErrorMessage: String
    ) {
        errorMessageMutableLiveData.postValue(
            if (errorMessage.isNotBlank()) Event(errorMessage) else Event(
                generalErrorMessage
            )
        )
    }
}