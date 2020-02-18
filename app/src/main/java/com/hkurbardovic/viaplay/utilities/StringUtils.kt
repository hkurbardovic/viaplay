package com.hkurbardovic.viaplay.utilities

object StringUtils {

    private const val SPLIT_HREF_CHARACTER = "{"

    fun splitHref(value: String) = value.split(SPLIT_HREF_CHARACTER)[0]
}