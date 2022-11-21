package com.avazpar.eventdog.home.data.store

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.avazpar.eventdog.home.domain.usecases.DogEvent
import com.avazpar.eventdog.home.domain.usecases.DogEventCategory

@Entity(tableName = "events")
data class EventEntity(
    @PrimaryKey(autoGenerate = true) val roomId: Int = 0,
    @ColumnInfo(name = "eventId")
    val eventId: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "subtitle")
    val subtitle: String,
    @ColumnInfo(name = "body")
    val body: String
)

fun EventEntity.asExternalModel() = DogEvent(
    id = eventId,
    title = title,
    subtitle = subtitle,
    body = body,
    category = DogEventCategory.SOCIAL
)

fun DogEvent.asEntity() = EventEntity(
    eventId = id,
    title = title,
    subtitle = subtitle,
    body = body
)