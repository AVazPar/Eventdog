package com.avazpar.eventdog.home.data.di

import android.app.Application
import androidx.room.Room
import com.avazpar.eventdog.home.data.datasource.local.LocalEventsDataSource
import com.avazpar.eventdog.home.data.datasource.local.LocalEventsDataSourceImpl
import com.avazpar.eventdog.home.data.datasource.remote.RemoteEventsDataSource
import com.avazpar.eventdog.home.data.datasource.remote.RemoteEventsDataSourceImpl
import com.avazpar.eventdog.home.data.repository.EventsRepositoryImpl
import com.avazpar.eventdog.home.data.store.EventDao
import com.avazpar.eventdog.home.data.store.EventsDatabase
import com.avazpar.eventdog.home.domain.repository.EventsRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val eventsDataBase = module {
    fun provideDataBase(application: Application): EventsDatabase {
        return Room.databaseBuilder(application, EventsDatabase::class.java, "USERDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(dataBase: EventsDatabase): EventDao {
        return dataBase.eventDao()
    }
    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }

}

val homeDataModule = module {
    single<EventsRepository> {
        EventsRepositoryImpl(
            localDataSource = get(),
            remoteDataSource = get()
        )
    }

    single<LocalEventsDataSource> {
        LocalEventsDataSourceImpl(
            eventDao = get()
        )
    }
    single<RemoteEventsDataSource> { RemoteEventsDataSourceImpl() }
}