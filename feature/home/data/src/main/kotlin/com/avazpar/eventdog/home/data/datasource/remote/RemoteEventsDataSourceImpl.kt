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

    override fun getEventDetails(id: String): DogEvent = event1
}

val event1 = DogEvent(
    id = 1,
    title = "Perrotón race",
    subtitle = "Run with your dog in Madrid",
    body = "Run with your dog in Madrid Run with your dog in Madrid Run with your dog in Madrid Run with your dog in Madrid v Run with your dog in Madrid",
    category = DogEventCategory.FOOD
)