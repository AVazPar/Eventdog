package com.avazpar.eventdog.home.data.datasource.remote

import com.avazpar.eventdog.home.data.network.EventApi
import com.avazpar.eventdog.home.data.store.EventModel
import com.avazpar.eventdog.home.data.store.asDogEvent
import com.avazpar.eventdog.home.domain.usecases.DogEvent
import com.avazpar.eventdog.home.domain.usecases.DogEventCategory

class RemoteEventsDataSourceImpl(
    private val eventApi: EventApi
) : RemoteEventsDataSource{

    override suspend fun getAllEvents(): List<DogEvent> =
        eventApi.getAllEvents().events.map(EventModel::asDogEvent)
}