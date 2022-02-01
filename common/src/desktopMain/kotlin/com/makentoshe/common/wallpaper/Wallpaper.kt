package com.makentoshe.common.wallpaper

import java.io.File

actual interface Wallpaper<T: Any> {
    actual fun get(): T
}

data class DesktopWallpaper(val file: File): Wallpaper<String> {
    override fun get(): String = file.absolutePath
}
