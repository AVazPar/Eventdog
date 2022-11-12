package com.avazpar.eventdog.home.data.di

import com.avazpar.eventdog.home.data.datasource.local.LocalEventsDataSource
import com.avazpar.eventdog.home.data.datasource.local.LocalEventsDataSourceImpl
import com.avazpar.eventdog.home.data.datasource.remote.RemoteEventsDataSource
import com.avazpar.eventdog.home.data.datasource.remote.RemoteEventsDataSourceImpl
import com.avazpar.eventdog.home.data.repository.EventsRepositoryImpl
import com.avazpar.eventdog.home.domain.repository.EventsRepository
import org.koin.dsl.module

val homeDataModule = module {
    single<EventsRepository> {
        EventsRepositoryImpl(
            localDataSource = get(),
            remoteDataSource = get()
        )
    }

    single<LocalEventsDataSource> { LocalEventsDataSourceImpl() }
    single<RemoteEventsDataSource> { RemoteEventsDataSourceImpl() }
}