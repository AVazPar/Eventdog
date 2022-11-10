package com.avazpar.eventdog.home.data.di

import com.avazpar.eventdog.home.domain.repository.EventsRepository
import org.koin.dsl.module

val homeDataModule = module {
   // single<EventsRepository> { EventsRepositoryImpl() }
}