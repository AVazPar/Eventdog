package com.avazpar.eventdog.home.domain.di

import com.avazpar.eventdog.home.domain.usecases.GetAllDogEvents
import org.koin.dsl.module

val homeDomainModule = module {
    factory {
        GetAllDogEvents(
            eventsRepository = get()
        )
    }
}