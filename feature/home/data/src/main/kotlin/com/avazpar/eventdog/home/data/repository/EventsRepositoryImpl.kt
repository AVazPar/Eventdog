package com.avazpar.eventdog.home.data.repository

import com.avazpar.eventdog.home.data.datasource.local.LocalEventsDataSource
import com.avazpar.eventdog.home.data.datasource.remote.RemoteEventsDataSource
import com.avazpar.eventdog.home.domain.repository.EventsRepository
import com.avazpar.eventdog.home.domain.usecases.DogEvent
import kotlinx.coroutines.flow.Flow

class EventsRepositoryImpl(
    val localDataSource: LocalEventsDataSource,
    val remoteDataSource: RemoteEventsDataSource
) : EventsRepository {

    override fun getAllEvents(): Flow<List<DogEvent>> =
        remoteDataSource.getAllEvents()

    override fun getEventDetails(id: String): Flow<DogEvent> =
        remoteDataSource.getEventDetails(id = id)
}