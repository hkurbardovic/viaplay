package com.hkurbardovic.viaplay.network

import com.hkurbardovic.viaplay.network.responses.ViaplayResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET("androiddash-se")
    suspend fun getSections(): Response<ViaplayResponse?>

    @GET
    suspend fun getSectionDetails(@Url href: String): Response<ViaplayResponse?>
}