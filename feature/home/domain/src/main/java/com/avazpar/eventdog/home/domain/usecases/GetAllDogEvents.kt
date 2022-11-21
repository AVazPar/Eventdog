package com.avazpar.eventdog.home.domain.usecases

import com.avazpar.eventdog.home.domain.repository.EventsRepository
import kotlinx.coroutines.flow.Flow

class GetAllDogEvents(
    private val eventsRepository: EventsRepository
) {
    suspend operator fun invoke(): Flow<List<DogEvent>> = eventsRepository.getAllEvents()
}

data class DogEvent(
    val id: Int,
    val title: String,
    val subtitle: String,
    val body: String,
    val category: DogEventCategory
)

enum class DogEventCategory{
    SOCIAL, SPORT, HEALTH, FOOD
}