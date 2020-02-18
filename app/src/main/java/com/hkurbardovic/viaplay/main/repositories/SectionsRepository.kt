package com.hkurbardovic.viaplay.main.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.hkurbardovic.viaplay.R
import com.hkurbardovic.viaplay.base.BaseRepository
import com.hkurbardovic.viaplay.database.DatabaseHandler
import com.hkurbardovic.viaplay.database.ViaplayDatabase
import com.hkurbardovic.viaplay.database.models.Section
import com.hkurbardovic.viaplay.database.models.SectionDetails
import com.hkurbardovic.viaplay.network.ApiService
import com.hkurbardovic.viaplay.utilities.Event
import javax.inject.Inject

class SectionsRepository @Inject constructor(
    private val context: Context,
    private val apiService: ApiService,
    private val database: ViaplayDatabase,
    private val databaseHandler: DatabaseHandler
) : BaseRepository() {

    private val errorMessageMutableLiveData = MutableLiveData<Event<String?>?>()

    private val sectionIdMutableLiveData = MutableLiveData<String>()

    private val isLoadingMutableLiveData = MutableLiveData<Boolean>()

    val sectionsLiveData: LiveData<PagedList<Section>> =
        database.sectionDao().getAll().toLiveData(20)

    val sectionDetailsLiveData: LiveData<SectionDetails?> = sectionIdMutableLiveData.switchMap {
        database.sectionDetailsDao().getSectionDetails(it)
    }

    val errorMessageLiveData: LiveData<Event<String?>?> = errorMessageMutableLiveData

    val isLoadingLiveData: LiveData<Boolean> = isLoadingMutableLiveData

    suspend fun getSections() {
        isLoadingMutableLiveData.postValue(true)
        try {
            val response = apiService.getSections()

            if (response.isSuccessful) {
                databaseHandler.insertSectionsDatabase(response.body())
            } else {
                handleException(
                    errorMessageMutableLiveData,
                    response.message(),
                    context.getString(R.string.general_error_message)
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            handleException(
                errorMessageMutableLiveData,
                e.localizedMessage ?: "",
                context.getString(R.string.general_error_message)
            )
        } finally {
            isLoadingMutableLiveData.postValue(false)
        }
    }

    suspend fun getSectionDetails(href: String) {
        isLoadingMutableLiveData.postValue(true)
        try {
            val response = apiService.getSectionDetails(href)

            if (response.isSuccessful) {
                databaseHandler.insertSectionDetailsDatabase(response.body())
                databaseHandler.insertSectionsDatabase(response.body())
            } else {
                handleException(
                    errorMessageMutableLiveData,
                    response.message(),
                    context.getString(R.string.general_error_message)
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            handleException(
                errorMessageMutableLiveData,
                e.localizedMessage ?: "",
                context.getString(R.string.general_error_message)
            )
        } finally {
            isLoadingMutableLiveData.postValue(false)
        }
    }

    fun postSectionIdValue(id: String) {
        sectionIdMutableLiveData.postValue(id)
    }
}