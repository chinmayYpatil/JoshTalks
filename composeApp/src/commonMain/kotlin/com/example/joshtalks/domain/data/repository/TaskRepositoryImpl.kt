package com.example.joshtalks.domain.repository

import com.example.joshtalks.domain.model.ReadingPassage
import com.example.joshtalks.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    // Remote/API Functions
    suspend fun fetchPassageForReading(): ReadingPassage

    // Local/Database Functions
    suspend fun saveTask(task: Task)

    fun getTaskHistory(): Flow<List<Task>>

    // Platform-specific utility
    fun getLocalImagePath(fileName: String): String
}