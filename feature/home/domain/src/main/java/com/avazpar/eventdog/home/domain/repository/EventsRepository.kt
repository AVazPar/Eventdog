package com.avazpar.eventdog.home.domain.repository

import com.avazpar.eventdog.home.domain.usecases.DogEvent
import kotlinx.coroutines.flow.Flow

interface EventsRepository {
    suspend fun getAllEvents(): Flow<List<DogEvent>>
    fun getEventDetails(eventId: Int): Flow<DogEvent>
}