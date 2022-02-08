package com.makentoshe.common.wallpaper

import java.io.File
import java.nio.file.Files

actual interface WallpaperSetter<T : Any> {
    actual fun setup(wallpaper: Wallpaper<T>): Boolean
}

class DesktopWallpaperSetter : WallpaperSetter<String> {

    override fun setup(wallpaper: Wallpaper<String>): Boolean {
        val file = File(wallpaper.get())
        if (!file.exists() || !file.isImage) return false

        return WindowsUser32.INSTANCE.SystemParametersInfo(WindowsUser32.SPI_SETDESKWALLPAPER, 0, wallpaper.get(), 1)
    }

    private val File.isImage: Boolean
        get() = Files.probeContentType(toPath()).let { type ->
            type != null && type.split("/")[0] == "image"
        }
}
