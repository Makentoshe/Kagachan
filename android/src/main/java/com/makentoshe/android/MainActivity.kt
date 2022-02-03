package com.makentoshe.android

import android.app.WallpaperManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.makentoshe.common.App
import com.makentoshe.common.wallpaper.AndroidWallpaper
import com.makentoshe.common.wallpaper.AndroidWallpaperSetter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { App() } }

        val wallpaperManager = WallpaperManager.getInstance(this)
        val drawable = ContextCompat.getDrawable(this, R.drawable.sas)!!
        AndroidWallpaperSetter(wallpaperManager).setup(AndroidWallpaper(drawable.toBitmap()))
    }

}