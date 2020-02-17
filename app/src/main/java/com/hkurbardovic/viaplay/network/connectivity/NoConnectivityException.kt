package com.hkurbardovic.viaplay.network.connectivity

import java.io.IOException

class NoConnectivityException(private val errorMessage: String) : IOException() {

    override fun getLocalizedMessage() = errorMessage
}