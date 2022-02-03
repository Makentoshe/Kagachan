package com.makentoshe.common.wallpaper

import android.app.WallpaperManager
import android.graphics.Bitmap
import java.io.IOException

actual interface WallpaperSetter<T : Any> {
    actual fun setup(wallpaper: Wallpaper<T>): Boolean
}

class AndroidWallpaperSetter(private val wallpaperManager: WallpaperManager) : WallpaperSetter<Bitmap> {
    override fun setup(wallpaper: Wallpaper<Bitmap>): Boolean = try {
        wallpaperManager.setBitmap(wallpaper.get())
        true
    } catch (ioe: IOException) {
        false
    }
}