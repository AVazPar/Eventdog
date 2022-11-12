package com.avazpar.eventdog.home.domain.usecases

import androidx.annotation.DrawableRes
import com.avazpar.eventdog.home.domain.repository.EventsRepository
import kotlinx.coroutines.flow.Flow

class GetAllDogEvents(
    private val eventsRepository: EventsRepository
) {
    operator fun invoke(): Flow<List<DogEvent>> = eventsRepository.getAllEvents()
}

data class DogEvent(
    val id: String,
    val title: String,
    val subtitle: String,
  //  @DrawableRes val imageId: Int,
  //  @DrawableRes val imageThumbId: Int
)