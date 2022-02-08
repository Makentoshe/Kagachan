package com.makentoshe.desktop

import com.makentoshe.common.wallpaper.DesktopWallpaper
import com.makentoshe.common.wallpaper.DesktopWallpaperSetter
import java.io.File

//fun main() = application {
//    Window(onCloseRequest = ::exitApplication) {
//        DesktopMaterialTheme {
//            App()
//        }
//    }
//}

fun main() {
    val file = File("C:\\Users\\Maxim_Khvostov\\Pictures\\asa.jpg")
    println("Exists File($file): ${file.exists()}")
    DesktopWallpaperSetter().setup(DesktopWallpaper(File("")))
}
