package com.hkurbardovic.viaplay.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "section")
class Section(
    @PrimaryKey val id: String,
    val title: String,
    val href: String,
    val type: String,
    val name: String,
    val templated: Boolean
) {
    override fun toString() = name
}