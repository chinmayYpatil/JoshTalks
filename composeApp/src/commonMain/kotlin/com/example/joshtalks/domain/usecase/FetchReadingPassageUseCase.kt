package com.example.joshtalks.domain.usecase


import com.example.joshtalks.domain.model.ReadingPassage
import com.example.joshtalks.domain.repository.TaskRepository

class FetchReadingPassageUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(): ReadingPassage {
        return repository.fetchPassageForReading()
    }
}