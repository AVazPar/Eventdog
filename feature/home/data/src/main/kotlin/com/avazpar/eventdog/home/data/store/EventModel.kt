package com.avazpar.eventdog.home.data.store

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventModel(
    @Json(name = "eventId") val eventId: Int,
    @Json(name = "title") val title: String,
    @Json(name = "subtitle") val subtitle: String,
    @Json(name = "body") val body: String
)

fun EventModel.asEntity(eventId: Int) = EventEntity(
    eventId = eventId,
    title = title,
    subtitle = subtitle,
    body = body,
)