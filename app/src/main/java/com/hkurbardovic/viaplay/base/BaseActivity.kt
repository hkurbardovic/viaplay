package com.hkurbardovic.viaplay.base

import androidx.fragment.app.Fragment
import com.hkurbardovic.viaplay.R
import com.hkurbardovic.viaplay.utilities.inTransaction
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    fun addFragment(fragment: Fragment) {
        if (fragment.isAdded) return
        supportFragmentManager.inTransaction {
            setCustomAnimations(
                android.R.anim.fade_in,
                android.R.anim.fade_out,
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )

            addToBackStack(fragment::class.java.name)
            add(R.id.fragment_container, fragment)
        }
    }

    fun replaceFragment(fragment: Fragment) {
        if (fragment.isAdded) return
        supportFragmentManager.inTransaction {
            replace(R.id.fragment_container, fragment)
        }
    }
}