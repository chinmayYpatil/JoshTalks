package com.example.joshtalks.data.platform

actual interface PlatformFileManager {
    actual fun getStoragePath(fileName: String): String
}