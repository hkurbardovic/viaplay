package com.hkurbardovic.viaplay.network.responses

import com.google.gson.annotations.SerializedName
import com.hkurbardovic.viaplay.network.models.Links

data class ViaplayResponse(@SerializedName("_links") val links: Links?)