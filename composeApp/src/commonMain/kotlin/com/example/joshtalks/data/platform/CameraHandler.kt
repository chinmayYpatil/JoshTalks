package com.example.joshtalks.data.platform

expect class CameraHandler {
    suspend fun takePhoto(fileName: String): String
}