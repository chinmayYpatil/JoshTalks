package com.example.joshtalks.domain.usecase


import com.example.joshtalks.domain.model.Task
import com.example.joshtalks.domain.repository.TaskRepository

class SaveTaskUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(task: Task) {
        repository.saveTask(task)
    }
}