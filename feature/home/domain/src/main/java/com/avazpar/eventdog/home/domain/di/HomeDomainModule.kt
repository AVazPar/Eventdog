package com.avazpar.eventdog.home.domain.di

import com.avazpar.eventdog.home.domain.usecases.GetAllDogEvents
import com.avazpar.eventdog.home.domain.usecases.GetDogEventDetails
import org.koin.dsl.module

val homeDomainModule = module {
    factory {
        GetAllDogEvents(
            eventsRepository = get()
        )
    }
    factory {
        GetDogEventDetails(
            eventsRepository = get()
        )
    }
}