package com.makentoshe.common.wallpaper

import android.graphics.Bitmap

actual interface WallpaperSetter<T : Any> {
    actual fun setup(wallpaper: Wallpaper<T>): Boolean
}

class AndroidWallpaperSetter : WallpaperSetter<Bitmap>{
    override fun setup(wallpaper: Wallpaper<Bitmap>): Boolean {

        return true
    }
}