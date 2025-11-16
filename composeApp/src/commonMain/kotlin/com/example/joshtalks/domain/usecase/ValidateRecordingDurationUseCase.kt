package com.example.joshtalks.domain.usecase


class ValidateRecordingDurationUseCase {
    private val MIN_DURATION_SECONDS = 10
    private val MAX_DURATION_SECONDS = 20

    operator fun invoke(duration: Int): ValidationResult {
        return when {
            duration < MIN_DURATION_SECONDS -> ValidationResult.TooShort(MIN_DURATION_SECONDS)
            duration > MAX_DURATION_SECONDS -> ValidationResult.TooLong(MAX_DURATION_SECONDS)
            else -> ValidationResult.Valid
        }
    }
}

sealed class ValidationResult {
    data object Valid : ValidationResult()
    data class TooShort(val min: Int) : ValidationResult()
    data class TooLong(val max: Int) : ValidationResult()
}