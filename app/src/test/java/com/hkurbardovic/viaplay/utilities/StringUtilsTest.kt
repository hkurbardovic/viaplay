package com.hkurbardovic.viaplay.utilities

import org.junit.Assert
import org.junit.Test

class StringUtilsTest {

    @Test
    fun splitHref_isCorrect() {
        Assert.assertEquals(
            "https://content.viaplay.se/androiddash-se/serier",
            StringUtils.splitHref("https://content.viaplay.se/androiddash-se/serier{?dtg}")
        )
        Assert.assertEquals(
            "https://content.viaplay.se/androiddash-se/film",
            StringUtils.splitHref("https://content.viaplay.se/androiddash-se/film{?dtg}")
        )
        Assert.assertEquals(
            "https://content.viaplay.se/androiddash-se/sport3",
            StringUtils.splitHref("https://content.viaplay.se/androiddash-se/sport3{?dtg}")
        )
        Assert.assertEquals(
            "https://content.viaplay.se/androiddash-se/sport2",
            StringUtils.splitHref("https://content.viaplay.se/androiddash-se/sport2{?dtg}")
        )
        Assert.assertEquals(
            "https://content.viaplay.se/androiddash-se/sport",
            StringUtils.splitHref("https://content.viaplay.se/androiddash-se/sport{?dtg}")
        )
        Assert.assertEquals(
            "https://content.viaplay.se/androiddash-se/barn",
            StringUtils.splitHref("https://content.viaplay.se/androiddash-se/barn{?dtg}")
        )
        Assert.assertEquals(
            "https://content.viaplay.se/androiddash-se/store",
            StringUtils.splitHref("https://content.viaplay.se/androiddash-se/store{?dtg}")
        )
    }
}