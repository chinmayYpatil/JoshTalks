package com.example.joshtalks.domain.usecase


import com.example.joshtalks.domain.model.Task
import com.example.joshtalks.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.time.Duration.Companion.seconds

class CalculateTotalDurationUseCase(
    private val repository: TaskRepository
) {
    operator fun invoke(): Flow<String> {
        return repository.getTaskHistory().map { tasks ->
            val totalSeconds = tasks.sumOf { task ->
                // Safely sum up audio duration, handling optional audio (PhotoCaptureTask)
                when (task) {
                    is Task.TextReadingTask -> task.audio.durationSeconds
                    is Task.ImageDescriptionTask -> task.audio.durationSeconds
                    is Task.PhotoCaptureTask -> task.audio?.durationSeconds ?: 0
                }
            }

            // Format seconds into "12m 34s" format
            val duration = totalSeconds.seconds

            val minutes = duration.inWholeMinutes
            val seconds = duration.inWholeSeconds % 60

            "${minutes}m ${seconds}s"
        }
    }
}