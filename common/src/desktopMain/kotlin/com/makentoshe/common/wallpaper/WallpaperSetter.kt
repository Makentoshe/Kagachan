package com.makentoshe.common.wallpaper

actual interface WallpaperSetter<T : Any> {
    actual fun setup(wallpaper: Wallpaper<T>): Boolean
}

class DesktopWallpaperSetter : WallpaperSetter<String>{
    override fun setup(wallpaper: Wallpaper<String>): Boolean {

        return true
    }
}