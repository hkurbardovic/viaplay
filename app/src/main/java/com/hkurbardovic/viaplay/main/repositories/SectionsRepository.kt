package com.hkurbardovic.viaplay.main.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.hkurbardovic.viaplay.R
import com.hkurbardovic.viaplay.base.BaseRepository
import com.hkurbardovic.viaplay.database.ViaplayDatabase
import com.hkurbardovic.viaplay.database.models.Section
import com.hkurbardovic.viaplay.network.ApiService
import com.hkurbardovic.viaplay.network.responses.ViaplayResponse
import com.hkurbardovic.viaplay.utilities.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SectionsRepository @Inject constructor(
    private val context: Context,
    private val apiService: ApiService,
    private val database: ViaplayDatabase
) : BaseRepository() {

    private val errorMessageMutableLiveData = MutableLiveData<Event<String?>?>()

    val sectionsLiveData: LiveData<PagedList<Section>> = database.sectionDao().getAll().toLiveData(50)

    val errorMessageLiveData: LiveData<Event<String?>?> = errorMessageMutableLiveData

    suspend fun getSections() {
        try {
            withContext(Dispatchers.IO) {
                val response = apiService.getSections()

                if (response.isSuccessful) {
                    insertDatabase(response.body())
                } else {
                    withContext(Dispatchers.Main) {
                        handleException(
                            errorMessageMutableLiveData,
                            response.message(),
                            context.getString(R.string.general_error_message)
                        )
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            handleException(
                errorMessageMutableLiveData,
                e.localizedMessage ?: "",
                context.getString(R.string.general_error_message)
            )
        }
    }

    private fun insertDatabase(viaplayResponse: ViaplayResponse?) {
        viaplayResponse?.links?.sections?.let { sections ->
            for (section in sections) {
                section?.toSectionDb()?.let {
                    database.sectionDao().insertSection(it)
                }
            }
        }
    }
}