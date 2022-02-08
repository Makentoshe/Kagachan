package com.makentoshe.common

import com.makentoshe.common.functional.right
import com.makentoshe.common.wallpaper.DesktopWallpaper
import com.makentoshe.common.wallpaper.DesktopWallpaperSetter
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class DesktopWallpaperSetterTest {

    private val wallpaperSetter = DesktopWallpaperSetter()

    @Test
    fun checkFileNotExists() {
        val file = File("sdufsfjsf.png")
        val result = wallpaperSetter.setup(DesktopWallpaper(file))

        val right = result.right() as FileSystemException
        assertEquals(right.file.absolutePath, file.absolutePath)
    }

    @Test
    fun checkFileIsImage(){
        val resourceName = "w.jpg"

        val classLoader = javaClass.classLoader
        val file = File(classLoader.getResource(resourceName).file)

        val result = wallpaperSetter.setup(DesktopWallpaper(file))

        assert(result.isLeft)
    }

    @Test
    fun checkFileIsNotImage(){
        val resourceName = "w.txt"

        val classLoader = javaClass.classLoader
        val file = File(classLoader.getResource(resourceName).file)

        val result = wallpaperSetter.setup(DesktopWallpaper(file))

        val right = result.right() as FileSystemException
        assertEquals(right.file.absolutePath, file.absolutePath)
    }

}