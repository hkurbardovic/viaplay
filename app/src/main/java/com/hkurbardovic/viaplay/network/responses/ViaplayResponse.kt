package com.hkurbardovic.viaplay.network.responses

import com.google.gson.annotations.SerializedName
import com.hkurbardovic.viaplay.network.models.Links

data class ViaplayResponse(
    val type: String?,
    val pageType: String?,
    val sectionId: String?,
    val title: String?,
    val description: String?,
    @SerializedName("_links") val links: Links?
)