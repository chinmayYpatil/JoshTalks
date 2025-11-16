package com.example.joshtalks.data.platform


import kotlinx.coroutines.flow.Flow

expect class NoiseMonitor {
    val dbLevel: Flow<Double>

    fun startMonitoring()

    fun stopMonitoring()
}