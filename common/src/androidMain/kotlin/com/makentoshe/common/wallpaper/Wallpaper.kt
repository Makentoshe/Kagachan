package com.makentoshe.common.wallpaper

import android.graphics.Bitmap

actual interface Wallpaper<T : Any> {
    actual fun get(): T
}

data class AndroidWallpaper(val bitmap: Bitmap) : Wallpaper<Bitmap> {
    override fun get() = bitmap
}