package com.hkurbardovic.viaplay.database

import com.hkurbardovic.viaplay.database.models.SectionDetails
import com.hkurbardovic.viaplay.network.responses.ViaplayResponse
import javax.inject.Inject

class DatabaseHandler @Inject constructor(private val database: ViaplayDatabase) {

    fun insertSectionDetailsDatabase(viaplayResponse: ViaplayResponse?) {
        viaplayResponse?.let {
            if (it.sectionId == null) return
            val sectionDetails = SectionDetails(
                it.sectionId,
                it.type ?: "",
                it.pageType ?: "",
                it.title ?: "",
                it.description ?: ""
            )

            database.sectionDetailsDao().insertSectionDetails(sectionDetails)
        }
    }

    fun insertSectionsDatabase(viaplayResponse: ViaplayResponse?) {
        viaplayResponse?.links?.sections?.let { sections ->
            for (section in sections) {
                section?.toSectionDb()?.let {
                    database.sectionDao().insertSection(it)
                }
            }
        }
    }
}