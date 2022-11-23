package com.avazpar.eventdog.home.data.datasource.remote

import com.avazpar.eventdog.home.domain.usecases.DogEvent
import kotlinx.coroutines.flow.Flow

interface RemoteEventsDataSource {
    suspend fun getAllEvents(): List<DogEvent>
}