package com.hkurbardovic.viaplay.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.hkurbardovic.viaplay.R
import com.hkurbardovic.viaplay.base.BaseActivity
import com.hkurbardovic.viaplay.databinding.ActivityMainBinding
import com.hkurbardovic.viaplay.handlers.network.NetworkConnectivityChangeHandler
import com.hkurbardovic.viaplay.handlers.network.NetworkConnectivityChangeListener
import com.hkurbardovic.viaplay.main.fragments.SectionsFragment

class MainActivity : BaseActivity(), NetworkConnectivityChangeListener {

    private lateinit var binding: ActivityMainBinding

    private var networkListener: NetworkListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        registerNetworkListener()

        if (savedInstanceState == null) replaceFragment(SectionsFragment.newInstance())
    }

    override fun onLost() {
        showMessage(getString(R.string.no_internet_connection), binding.coordinator)
    }

    override fun onAvailable() {
        networkListener?.onAvailable()
    }

    private fun registerNetworkListener() {
        val networkConnectivityChangeHandler = NetworkConnectivityChangeHandler(this)
        networkConnectivityChangeHandler.setCallback(this)
    }

    fun showMessage(message: String?) {
        message?.let {
            showMessage(it, binding.coordinator)
        }
    }

    fun setNetworkListener(networkListener: NetworkListener) {
        this.networkListener = networkListener
    }

    interface NetworkListener {
        fun onAvailable()
    }
}
