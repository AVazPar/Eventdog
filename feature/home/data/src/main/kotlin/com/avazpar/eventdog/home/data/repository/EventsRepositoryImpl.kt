package com.avazpar.eventdog.home.data.repository

import com.avazpar.eventdog.home.data.datasource.local.LocalEventsDataSource
import com.avazpar.eventdog.home.data.datasource.remote.RemoteEventsDataSource
import com.avazpar.eventdog.home.data.store.EventEntity
import com.avazpar.eventdog.home.data.store.asEntity
import com.avazpar.eventdog.home.data.store.asExternalModel
import com.avazpar.eventdog.home.domain.repository.EventsRepository
import com.avazpar.eventdog.home.domain.usecases.DogEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class EventsRepositoryImpl(
    val localDataSource: LocalEventsDataSource,
    val remoteDataSource: RemoteEventsDataSource
) : EventsRepository {

    override suspend fun getAllEvents(): Flow<List<DogEvent>> =
        localDataSource.getAllEvents().map { list ->
            list.map(EventEntity::asExternalModel)
        }.onEach {
            if(it.isEmpty()){
                refreshEvents()
            }
        }

    private suspend fun refreshEvents() =
        remoteDataSource.getAllEvents()
            .toMutableList().apply { shuffle() }
            .also { events ->
                localDataSource.saveAllEvents(
                    list = events.map(DogEvent::asEntity)
                )
            }

    override fun getEventDetails(id: String): Flow<DogEvent> =
        flowOf(remoteDataSource.getEventDetails(id = id))
}
