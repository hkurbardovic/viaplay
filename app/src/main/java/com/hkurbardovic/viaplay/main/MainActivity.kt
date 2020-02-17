package com.hkurbardovic.viaplay.main

import android.os.Bundle
import com.hkurbardovic.viaplay.R
import com.hkurbardovic.viaplay.base.BaseActivity
import com.hkurbardovic.viaplay.main.fragments.SectionsFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) replaceFragment(SectionsFragment.newInstance())
    }
}
