package com.avazpar.eventdog.home.data.store

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(
    entities = [EventEntity::class],
    version = 1,
    exportSchema = false
)
abstract class EventsDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
}