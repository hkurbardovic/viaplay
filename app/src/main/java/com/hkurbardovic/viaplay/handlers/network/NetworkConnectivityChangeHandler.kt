package com.hkurbardovic.viaplay.handlers.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import timber.log.Timber
import javax.inject.Inject

class NetworkConnectivityChangeHandler @Inject constructor(private val context: Context) :
    NetworkConnectivityChangeListener {

    private lateinit var networkConnectivityChangeListener: NetworkConnectivityChangeListener

    override fun onLost() {
        networkConnectivityChangeListener.onLost()
    }

    override fun onAvailable() {
        networkConnectivityChangeListener.onAvailable()
    }

    fun setCallback(networkConnectivityChangeListener: NetworkConnectivityChangeListener) {
        this.networkConnectivityChangeListener = networkConnectivityChangeListener
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkRequest = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
    }

    private var networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onLost(network: Network?) {
            Timber.d("Network is lost")
            networkConnectivityChangeListener.onLost()
        }

        override fun onUnavailable() {
            Timber.d("Network is unavailable")
        }

        override fun onLosing(network: Network?, maxMsToLive: Int) {
            Timber.d("Network is losing")
        }

        override fun onAvailable(network: Network?) {
            Timber.d("Network is available")
            networkConnectivityChangeListener.onAvailable()
        }
    }
}