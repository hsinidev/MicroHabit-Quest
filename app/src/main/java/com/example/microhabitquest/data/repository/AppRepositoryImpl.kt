package com.example.microhabitquest.data.repository

import com.example.microhabitquest.data.database.AppDao
import com.example.microhabitquest.data.database.AppLogEntity
import com.example.microhabitquest.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor(
    private val appDao: AppDao
) : AppRepository {
    override fun getLogs(): Flow<List<AppLogEntity>> = appDao.getLogs()

    override suspend fun addLog(title: String, content: String) {
        appDao.insertLog(AppLogEntity(UUID.randomUUID().toString(), title, content, System.currentTimeMillis()))
    }
}
