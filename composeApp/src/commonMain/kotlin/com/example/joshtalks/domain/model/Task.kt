package com.example.joshtalks.domain.model

sealed class Task {
    abstract val id: Long
    abstract val type: TaskType
    abstract val audio: RecordedAudio?

    data class TextReadingTask(
        override val id: Long,
        val text: String,
        override val audio: RecordedAudio,
        val hasNoise: Boolean,
        val hasReadingMistakes: Boolean
    ) : Task() {
        override val type: TaskType = TaskType.TEXT_READING
    }

    data class ImageDescriptionTask(
        override val id: Long,
        val imageUrl: String,
        override val audio: RecordedAudio
    ) : Task() {
        override val type: TaskType = TaskType.IMAGE_DESCRIPTION
    }

    data class PhotoCaptureTask(
        override val id: Long,
        val imagePath: String,
        val descriptionText: String? = null,
        override val audio: RecordedAudio? // Optional audio for description
    ) : Task() {
        override val type: TaskType = TaskType.PHOTO_CAPTURE
    }
}