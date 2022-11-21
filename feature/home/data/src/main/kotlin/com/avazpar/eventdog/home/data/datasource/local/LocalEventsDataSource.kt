package com.avazpar.eventdog.home.data.datasource.local

import com.avazpar.eventdog.home.data.store.EventEntity
import kotlinx.coroutines.flow.Flow

interface LocalEventsDataSource {
    suspend fun saveAllEvents(list: List<EventEntity>)
    fun getAllEvents(): Flow<List<EventEntity>>
}