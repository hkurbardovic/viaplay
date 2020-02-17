package com.hkurbardovic.viaplay.network.models

import com.google.gson.annotations.SerializedName

data class Links(@SerializedName("viaplay:sections") val sections: List<Section?>?)