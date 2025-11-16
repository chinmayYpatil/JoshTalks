package com.example.joshtalks.data.platform

import com.example.joshtalks.domain.model.RecordedAudio

expect class MicRecorder {
    fun startRecording(fileName: String)

    suspend fun stopRecording(): RecordedAudio

    fun playbackAudio(audioPath: String)
}