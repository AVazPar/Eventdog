package com.avazpar.eventdog.home.data.store

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
    @Query(value = "SELECT * FROM events")
    fun getAllEventsStream(): Flow<List<EventEntity>>

    @Query(value = "SELECT * FROM events WHERE eventId = :eventId")
    fun getEventForIdStream(eventId: Int): Flow<EventEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreEvents(events: List<EventEntity>)
}