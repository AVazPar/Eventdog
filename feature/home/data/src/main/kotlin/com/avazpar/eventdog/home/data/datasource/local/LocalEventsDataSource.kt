package com.avazpar.eventdog.home.data.datasource.local

import com.avazpar.eventdog.home.data.store.EventEntity
import com.avazpar.eventdog.home.domain.usecases.DogEvent
import kotlinx.coroutines.flow.Flow

interface LocalEventsDataSource {
    suspend fun saveAllEvents(list: List<EventEntity>)
    fun getAllEvents(): Flow<List<EventEntity>>
    fun getEventDetails(eventId: Int): Flow<DogEvent>
}