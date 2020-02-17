package com.hkurbardovic.viaplay.network.models

import com.hkurbardovic.viaplay.database.models.Section

data class Section(
    private val id: String?,
    private val title: String?,
    private val href: String?,
    private val type: String?,
    private val name: String?,
    private val templated: Boolean?
) {
    fun toSectionDb(): Section? {
        if (id == null) return null
        return Section(
            id,
            title ?: "",
            href ?: "",
            type ?: "",
            name ?: "",
            templated ?: false
        )
    }
}