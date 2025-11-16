package com.example.joshtalks.data.platform

import com.example.joshtalks.domain.model.RecordedAudio

actual class MicRecorder {
    actual fun startRecording(fileName: String) {
    }

    actual suspend fun stopRecording(): RecordedAudio {
        TODO("Not yet implemented")
    }

    actual fun playbackAudio(audioPath: String) {
    }
}