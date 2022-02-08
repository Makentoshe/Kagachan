package com.makentoshe.common.wallpaper

actual interface WallpaperSetter<T : Any> {
    actual fun setup(wallpaper: Wallpaper<T>): Boolean
}

class DesktopWallpaperSetter : WallpaperSetter<String> {
    override fun setup(wallpaper: Wallpaper<String>): Boolean {
        println(WindowsUser32.INSTANCE.SystemParametersInfo(WindowsUser32.SPI_SETDESKWALLPAPER, 0, wallpaper.get(), 1))
        return true
    }
}
