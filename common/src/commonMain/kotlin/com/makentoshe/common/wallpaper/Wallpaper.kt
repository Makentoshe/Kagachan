package com.makentoshe.common.wallpaper

expect interface Wallpaper<T : Any> {
    fun get(): T
}

