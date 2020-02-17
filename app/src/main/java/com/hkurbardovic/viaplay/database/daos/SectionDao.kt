package com.hkurbardovic.viaplay.database.daos

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hkurbardovic.viaplay.database.models.Section

@Dao
interface SectionDao {

    @Query("SELECT * FROM section")
    fun getAll(): DataSource.Factory<Int, Section>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSection(section: Section)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(sections: List<Section>)
}