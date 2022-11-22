package com.avazpar.eventdog.home.data.store

import com.avazpar.eventdog.home.domain.usecases.DogEvent
import com.avazpar.eventdog.home.domain.usecases.DogEventCategory
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventsModel(
    @Json(name = "events") val events: List<EventModel>
)

@JsonClass(generateAdapter = true)
data class EventModel(
    @Json(name = "id") val id: Int,
    @Json(name = "type") val type: String,
    @Json(name = "datetime_utc") val datetime_utc: String,
    @Json(name = "is_open") val is_open: Boolean,
    @Json(name = "short_title") val short_title: String,
    @Json(name = "title") val title: String,
    @Json(name = "description") val description: String,
    @Json(name = "status") val status: String
)

fun EventModel.asDogEvent() = DogEvent(
    id = id,
    title = short_title,
    subtitle = datetime_utc,
    body = description,
    category = getDogCategoryFromType(type = type)
)

fun getDogCategoryFromType(type: String) = when(type){
    "basketball" -> DogEventCategory.SPORT
    "concert" -> DogEventCategory.SOCIAL
    "theater" -> DogEventCategory.FOOD
    "family" -> DogEventCategory.HEALTH
    else -> DogEventCategory.SPORT
}