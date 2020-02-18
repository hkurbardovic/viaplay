package com.hkurbardovic.viaplay.handlers.click

class ClickHandler {

    fun onClick(command: Command) {
        command.execute()
    }
}