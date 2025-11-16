package com.example.joshtalks.domain.repository

import com.example.joshtalks.domain.model.ReadingPassage
import com.example.joshtalks.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun fetchPassageForReading(): ReadingPassage

    suspend fun saveTask(task: Task)

    fun getTaskHistory(): Flow<List<Task>>

    fun getLocalImagePath(fileName: String): String
}