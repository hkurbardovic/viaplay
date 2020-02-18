package com.hkurbardovic.viaplay.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hkurbardovic.viaplay.database.models.SectionDetails

@Dao
interface SectionDetailsDao {

    @Query("SELECT * FROM section_details where sectionId LIKE :id")
    fun getSectionDetails(id: String): LiveData<SectionDetails?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSectionDetails(sectionDetails: SectionDetails)
}