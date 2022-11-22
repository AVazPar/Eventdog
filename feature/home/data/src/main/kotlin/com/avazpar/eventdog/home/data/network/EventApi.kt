package com.avazpar.eventdog.home.data.network

import com.avazpar.eventdog.home.data.store.EventsModel
import retrofit2.http.GET

interface EventApi {

    @GET("events?$apiKeyId=$apiKeyValue")
    suspend fun getAllEvents(): EventsModel

    companion object{
        const val apiKeyId = "client_id"
        const val apiKeyValue = "MzAyOTU1NDJ8MTY2ODMzMDU4MC41NzI4NjYy"
    }
}