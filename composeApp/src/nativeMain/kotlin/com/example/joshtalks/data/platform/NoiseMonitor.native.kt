package com.example.joshtalks.data.platform

import kotlinx.coroutines.flow.Flow

actual class NoiseMonitor {
    actual val dbLevel: Flow<Double>
        get() = TODO("Not yet implemented")

    actual fun startMonitoring() {
    }

    actual fun stopMonitoring() {
    }
}