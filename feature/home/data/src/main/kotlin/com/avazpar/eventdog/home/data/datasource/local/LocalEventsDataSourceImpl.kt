package com.avazpar.eventdog.home.data.datasource.local

import com.avazpar.eventdog.home.data.store.EventDao
import com.avazpar.eventdog.home.data.store.EventEntity
import com.avazpar.eventdog.home.data.store.asExternalModel
import com.avazpar.eventdog.home.domain.usecases.DogEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalEventsDataSourceImpl(
    private val eventDao: EventDao
) : LocalEventsDataSource {

    override suspend fun saveAllEvents(list: List<EventEntity>) =
        eventDao.insertOrIgnoreEvents(events = list)

    override fun getAllEvents(): Flow<List<EventEntity>> =
        eventDao.getAllEventsStream()

    override fun getEventDetails(eventId: Int): Flow<DogEvent> =
        eventDao.getEventForIdStream(eventId = eventId).map {
            it.asExternalModel()
        }
}