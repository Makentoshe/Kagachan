package com.makentoshe.common.wallpaper

import android.app.WallpaperManager
import android.graphics.Bitmap
import com.makentoshe.common.functional.Either
import java.io.IOException

actual interface WallpaperSetter<T : Any> {
    actual fun setup(wallpaper: Wallpaper<T>): WallpaperResult
}

class AndroidWallpaperSetter(private val wallpaperManager: WallpaperManager) : WallpaperSetter<Bitmap> {
    override fun setup(wallpaper: Wallpaper<Bitmap>): WallpaperResult = try {
        wallpaperManager.setBitmap(wallpaper.get())
        Either.Left(Unit)
    } catch (e: Exception) {
        Either.Right(e)
    }
}