package com.avazpar.eventdog.home.data.datasource.remote

import com.avazpar.eventdog.home.domain.usecases.DogEvent
import com.avazpar.eventdog.home.domain.usecases.DogEventCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class RemoteEventsDataSourceImpl() : RemoteEventsDataSource{
    override fun getAllEvents(): List<DogEvent> = listOf(
        event1, event2, event3, event4
    )

    override fun getEventDetails(id: String): DogEvent = event1
}

val event1 = DogEvent(
    id = 1,
    title = "Perrotón race",
    subtitle = "Run with your dog in Madrid",
    body = "Run with your dog in Madrid Run with your dog in Madrid Run with your dog in Madrid Run with your dog in Madrid v Run with your dog in Madrid",
    category = DogEventCategory.FOOD
)

val event2 = DogEvent(
    id = 2,
    title = "Border collies in Aranjuez",
    subtitle = "Run with your dog in Madrid",
    body = "Run with your dog in Madrid Run with your dog in Madrid Run with your dog in Madrid Run with your dog in Madrid v Run with your dog in Madrid",
    category = DogEventCategory.HEALTH
)

val event3 = DogEvent(
    id = 3,
    title = "Coffee with dogs",
    subtitle = "Run with your dog in Madrid",
    body = "Run with your dog in Madrid Run with your dog in Madrid Run with your dog in Madrid Run with your dog in Madrid v Run with your dog in Madrid",
    category = DogEventCategory.SPORT
)

val event4 = DogEvent(
    id = 4,
    title = "Coffee with dogs",
    subtitle = "Run with your dog in Madrid",
    body = "Run with your dog in Madrid Run with your dog in Madrid Run with your dog in Madrid Run with your dog in Madrid v Run with your dog in Madrid",
    category = DogEventCategory.SOCIAL
)