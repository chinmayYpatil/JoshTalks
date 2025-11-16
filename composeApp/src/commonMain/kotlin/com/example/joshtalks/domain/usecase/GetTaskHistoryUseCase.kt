package com.example.joshtalks.domain.usecase

import com.example.joshtalks.domain.model.Task
import com.example.joshtalks.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetTaskHistoryUseCase(
    private val repository: TaskRepository
) {
    operator fun invoke(): Flow<List<Task>> {
        return repository.getTaskHistory()
    }
}