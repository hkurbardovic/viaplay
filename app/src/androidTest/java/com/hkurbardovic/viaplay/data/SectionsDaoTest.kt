package com.hkurbardovic.viaplay.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.toLiveData
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.hkurbardovic.viaplay.database.ViaplayDatabase
import com.hkurbardovic.viaplay.database.daos.SectionDao
import com.hkurbardovic.viaplay.database.models.Section
import com.hkurbardovic.viaplay.utilities.getValue
import org.hamcrest.Matchers
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SectionsDaoTest {
    private lateinit var database: ViaplayDatabase
    private lateinit var sectionsDao: SectionDao
    private val sectionA = Section("idA", "A", "href", "type", "name", false)
    private val sectionB = Section("idB", "B", "href", "type", "name", false)
    private val sectionC = Section("idC", "C", "href", "type", "name", false)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, ViaplayDatabase::class.java).build()
        sectionsDao = database.sectionDao()

        sectionsDao.insertAll(listOf(sectionA, sectionB, sectionC))
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun testGetSections() {
        val sections = getValue(sectionsDao.getAll().toLiveData(20))
        Assert.assertThat(sections.size, Matchers.equalTo(3))
    }
}