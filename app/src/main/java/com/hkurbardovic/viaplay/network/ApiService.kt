package com.hkurbardovic.viaplay.network

import com.hkurbardovic.viaplay.network.responses.ViaplayResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("androiddash-se")
    suspend fun getSections(): Response<ViaplayResponse?>
}