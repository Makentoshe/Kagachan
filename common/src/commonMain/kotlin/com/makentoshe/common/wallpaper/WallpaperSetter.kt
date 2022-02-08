package com.makentoshe.common.wallpaper

expect interface WallpaperSetter<T : Any> {
    fun setup(wallpaper: Wallpaper<T>): WallpaperResult
}