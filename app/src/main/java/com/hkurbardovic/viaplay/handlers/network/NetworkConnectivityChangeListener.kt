package com.hkurbardovic.viaplay.handlers.network

interface NetworkConnectivityChangeListener {

    fun onLost()

    fun onAvailable()
}