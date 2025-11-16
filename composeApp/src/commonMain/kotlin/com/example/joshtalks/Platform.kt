package com.example.joshtalks

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform