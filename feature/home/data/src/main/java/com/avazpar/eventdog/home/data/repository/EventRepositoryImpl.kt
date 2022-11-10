package com.avazpar.eventdog.home.data.repository

import com.avazpar.eventdog.home.domain.repository.EventsRepository
import com.avazpar.eventdog.home.domain.usecases.DogEvent
import kotlinx.coroutines.flow.Flow

class EventRepositoryImpl() : EventsRepository {

    override fun getAllEvents(): Flow<List<DogEvent>> {
        TODO("Not yet implemented")
    }
}