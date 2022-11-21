package com.avazpar.eventdog.home.data.datasource.local

import com.avazpar.eventdog.home.data.store.EventDao
import com.avazpar.eventdog.home.data.store.EventEntity
import kotlinx.coroutines.flow.Flow

class LocalEventsDataSourceImpl(
    private val eventDao: EventDao
) : LocalEventsDataSource {

    override suspend fun saveAllEvents(list: List<EventEntity>) =
        eventDao.insertOrIgnoreEvents(events = list)

    override fun getAllEvents(): Flow<List<EventEntity>> =
        eventDao.getAllEventsStream()
}