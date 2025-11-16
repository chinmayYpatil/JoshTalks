package com.example.joshtalks.data.platform

expect interface PlatformFileManager {
    fun getStoragePath(fileName: String): String
}