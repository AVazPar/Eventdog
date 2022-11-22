package com.avazpar.eventdog.home.domain.usecases

import com.avazpar.eventdog.home.domain.repository.EventsRepository
import kotlinx.coroutines.flow.Flow


class GetDogEventDetails(
    private val eventsRepository: EventsRepository
) {
    operator fun invoke(eventId: Int): Flow<DogEvent> =
        eventsRepository.getEventDetails(eventId)
}