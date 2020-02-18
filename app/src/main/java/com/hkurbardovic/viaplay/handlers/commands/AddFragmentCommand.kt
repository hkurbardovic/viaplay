package com.hkurbardovic.viaplay.handlers.commands

import android.content.Context
import androidx.fragment.app.Fragment
import com.hkurbardovic.viaplay.base.BaseActivity
import com.hkurbardovic.viaplay.handlers.click.Command

class AddFragmentCommand(private val context: Context, private val fragment: Fragment) :
    Command {

    override fun execute() {
        (context as BaseActivity).addFragment(fragment)
    }
}