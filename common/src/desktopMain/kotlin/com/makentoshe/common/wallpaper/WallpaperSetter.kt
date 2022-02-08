package com.makentoshe.common.wallpaper

import com.makentoshe.common.functional.Either
import java.io.File
import java.nio.file.Files

actual interface WallpaperSetter<T : Any> {
    actual fun setup(wallpaper: Wallpaper<T>): WallpaperResult
}

class DesktopWallpaperSetter : WallpaperSetter<String> {

    override fun setup(wallpaper: Wallpaper<String>): WallpaperResult = try {
        val wallpaperFile = File(wallpaper.get())

        if (!wallpaperFile.exists()) throw FileSystemException(wallpaperFile, reason = "File not exists")
        if (!wallpaperFile.isImage) throw FileSystemException(wallpaperFile, reason = "File is not an image")

        if (WindowsUser32.INSTANCE.SystemParametersInfo(WindowsUser32.SPI_SETDESKWALLPAPER, 0, wallpaper.get(), 1)) {
            Either.Left(Unit)
        } else {
            throw Exception("WinApi exception: SystemParametersInfo returns false")
        }
    } catch (e: Exception) {
        Either.Right(e)
    }

    private val File.isImage: Boolean
        get() = Files.probeContentType(toPath()).let { type ->
            type != null && type.split("/")[0] == "image"
        }
}
