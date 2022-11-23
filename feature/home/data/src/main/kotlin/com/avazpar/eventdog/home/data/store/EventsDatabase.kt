package com.avazpar.eventdog.home.data.store

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [EventEntity::class],
    version = 1,
    exportSchema = false
)
abstract class EventsDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
}