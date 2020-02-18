package com.hkurbardovic.viaplay.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.hkurbardovic.viaplay.database.ViaplayDatabase
import com.hkurbardovic.viaplay.database.daos.SectionDetailsDao
import com.hkurbardovic.viaplay.database.models.SectionDetails
import com.hkurbardovic.viaplay.utilities.getValue
import org.hamcrest.Matchers
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SectionDetailsDaoTest {
    private lateinit var database: ViaplayDatabase
    private lateinit var sectionDetailsDao: SectionDetailsDao
    private val sectionDetailsA = SectionDetails("idA", "type", "pageType", "A", "description")
    private val sectionDetailsB = SectionDetails("idB", "type", "pageType", "B", "description")
    private val sectionDetailsC = SectionDetails("idC", "type", "pageType", "C", "description")

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, ViaplayDatabase::class.java).build()
        sectionDetailsDao = database.sectionDetailsDao()

        sectionDetailsDao.insertSectionDetails(sectionDetailsA)
        sectionDetailsDao.insertSectionDetails(sectionDetailsB)
        sectionDetailsDao.insertSectionDetails(sectionDetailsC)
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun testGetSectionDetails() {
        Assert.assertThat(
            getValue(sectionDetailsDao.getSectionDetails(sectionDetailsA.sectionId)).toString(),
            Matchers.equalTo(sectionDetailsA.toString())
        )
    }
}