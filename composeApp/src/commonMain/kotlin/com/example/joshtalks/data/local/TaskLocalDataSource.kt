package com.example.joshtalks.data.local

import com.example.joshtalks.domain.model.RecordedAudio
import com.example.joshtalks.domain.model.Task
import com.example.joshtalks.domain.model.Task.TextReadingTask
import com.example.joshtalks.domain.model.Task.ImageDescriptionTask
import com.example.joshtalks.domain.model.Task.PhotoCaptureTask
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class TaskLocalDataSource {
    private val taskFlow = MutableStateFlow<List<Task>>(emptyList())
    private var nextMockId = 1001L

    fun getAllTasks(): Flow<List<Task>> = taskFlow

    suspend fun insertTask(task: Task) {
        taskFlow.update { currentTasks ->
            val newId = nextMockId++
            val taskWithId = when (task) {
                is TextReadingTask -> task.copy(id = newId)
                is ImageDescriptionTask -> task.copy(id = newId)
                is PhotoCaptureTask -> task.copy(id = newId)
            }
            currentTasks + taskWithId
        }
    }
}