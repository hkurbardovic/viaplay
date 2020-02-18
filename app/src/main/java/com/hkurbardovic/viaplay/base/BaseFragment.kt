package com.hkurbardovic.viaplay.base

import com.hkurbardovic.viaplay.main.MainActivity
import com.hkurbardovic.viaplay.utilities.Event
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    fun handleError(event: Event<String?>?) {
        event?.let {
            if (it.hasBeenHandled) return

            (context as MainActivity).showMessage(it.getContentIfNotHandled())
        }
    }
}