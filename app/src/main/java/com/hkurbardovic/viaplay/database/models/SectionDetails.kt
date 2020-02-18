package com.hkurbardovic.viaplay.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "section_details")
class SectionDetails(
    @PrimaryKey val sectionId: String,
    val type: String,
    val pageType: String,
    val title: String,
    val description: String
) {
    override fun toString() = title
}