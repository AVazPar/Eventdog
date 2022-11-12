package com.avazpar.eventdog.home.data.datasource.remote

import com.avazpar.eventdog.home.domain.usecases.DogEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class RemoteEventsDataSourceImpl() : RemoteEventsDataSource{
    override fun getAllEvents(): Flow<List<DogEvent>> = flowOf(listOf(
        event1, event2, event3
    ))

}

val event1 = DogEvent(
    id = "ac552dcc1741",
    title = "Perrotón race",
    subtitle = "Run with your dog in Madrid",
  //  imageId = R.drawable.post_3,
  //  imageThumbId = R.drawable.post_3_thumb
)

val event2 = DogEvent(
    id = "ac552dcc1742",
    title = "Border collies in Aranjuez",
    subtitle = "Run with your dog in Madrid",
   // imageId = R.drawable.post_3,
   // imageThumbId = R.drawable.post_3_thumb
)

val event3 = DogEvent(
    id = "ac552dcc1743",
    title = "Coffee with dogs",
    subtitle = "Run with your dog in Madrid",
   // imageId = R.drawable.post_3,
   // imageThumbId = R.drawable.post_3_thumb
)