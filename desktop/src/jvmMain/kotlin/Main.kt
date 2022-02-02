package com.makentoshe.desktop

import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.makentoshe.common.App


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        DesktopMaterialTheme {
            App()
        }
    }
}