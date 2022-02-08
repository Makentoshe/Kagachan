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
    val file = File("C:\\Users\\Maxim_Khvostov\\Desktop\\kicad-6.0.1-x86_64.exe")
    val result = DesktopWallpaperSetter().setup(DesktopWallpaper(file))

    result.fold({
        println("success")
    }, {
        println(it)
    })
}
