package com.avazpar.eventdog.home.domain.repository

import com.avazpar.eventdog.home.domain.usecases.DogEvent
import kotlinx.coroutines.flow.Flow

interface EventsRepository {
    fun getAllEvents(): Flow<List<DogEvent>>
    fun getEventDetails(id: String): Flow<DogEvent>
}