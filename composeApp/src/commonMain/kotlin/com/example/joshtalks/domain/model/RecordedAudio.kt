package com.example.joshtalks.domain.model

data class RecordedAudio(
    val path: String,
    val durationSeconds: Int,
    val timestamp: String
)