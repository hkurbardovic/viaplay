package com.hkurbardovic.viaplay.data

import com.hkurbardovic.viaplay.database.models.Section
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SectionTest {

    private lateinit var section: Section

    @Before
    fun setUp() {
        section = Section(
            "35bb8a90-d40e-11e2-8b8b-0800200c9a66",
            "Serier",
            "https://content.viaplay.se/androiddash-se/serier{?dtg}",
            "vod",
            "series",
            false
        )
    }

    @Test
    fun test_toString() {
        Assert.assertEquals("series", section.toString())
    }
}