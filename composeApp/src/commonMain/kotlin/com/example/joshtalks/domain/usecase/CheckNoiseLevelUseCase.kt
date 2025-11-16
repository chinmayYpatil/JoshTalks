package com.example.joshtalks.domain.usecase

import com.example.joshtalks.data.platform.NoiseMonitor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CheckNoiseLevelUseCase(
    private val noiseMonitor: NoiseMonitor // Platform dependency for mic access
) {
    // Acceptable threshold is defined in the assignment (40 dB)
    private val MAX_ACCEPTABLE_DB = 40.0

    suspend operator fun invoke(): Flow<Double> = flow {
        // Simulate checking the noise level asynchronously
        noiseMonitor.startMonitoring()

        // This flow will emit the current DB level for the UI to display the meter
        try {
            noiseMonitor.dbLevel.collect { db ->
                emit(db)
            }
        } finally {
            noiseMonitor.stopMonitoring()
        }
    }

    fun isLevelAcceptable(decibel: Double): Boolean {
        return decibel < MAX_ACCEPTABLE_DB
    }
}