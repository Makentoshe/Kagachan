package com.makentoshe.common.wallpaper

import com.sun.jna.Library
import com.sun.jna.Native
import com.sun.jna.win32.W32APIOptions

interface WindowsUser32 : Library {

    @Suppress("FunctionName")
    fun SystemParametersInfo(uiAction: Int, uiParam: Int, pvParam: String, fWinIni: Int): Boolean

    companion object {
        val INSTANCE = Native.loadLibrary("user32", WindowsUser32::class.java, W32APIOptions.DEFAULT_OPTIONS) as WindowsUser32

        const val SPI_SETDESKWALLPAPER = 0x0014
    }
}