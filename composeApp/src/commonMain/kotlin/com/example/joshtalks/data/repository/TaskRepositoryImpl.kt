package com.example.joshtalks.data.repository

import com.example.joshtalks.data.local.TaskLocalDataSource
import com.example.joshtalks.data.platform.PlatformFileManager
import com.example.joshtalks.data.remote.ProductRemoteDataSource
import com.example.joshtalks.domain.model.ReadingPassage
import com.example.joshtalks.domain.model.Task
import com.example.joshtalks.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(
    private val remoteSource: ProductRemoteDataSource,
    private val localSource: TaskLocalDataSource,
    private val fileManager: PlatformFileManager
) : TaskRepository {

    override suspend fun fetchPassageForReading(): ReadingPassage {
        return remoteSource.getReadingPassage()
    }

    override suspend fun saveTask(task: Task) {
        localSource.insertTask(task)
    }

    override fun getTaskHistory(): Flow<List<Task>> {
        return localSource.getAllTasks()
    }

    override fun getLocalImagePath(fileName: String): String {
        return fileManager.getStoragePath(fileName)
    }
}