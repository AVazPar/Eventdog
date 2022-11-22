package com.avazpar.eventdog.home.presentation.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avazpar.eventdog.home.domain.usecases.DogEventCategory
import com.avazpar.eventdog.home.domain.usecases.GetDogEventDetails
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class DetailsUIState(
    var title: String = "",
    var subtitle: String = "",
    var body: String = "",
    var category: DogEventCategory = DogEventCategory.FOOD
)

class DetailsViewModel(val getDogEventDetails: GetDogEventDetails) : ViewModel() {
    private val _uiState = MutableStateFlow(DetailsUIState())
    val uiState = _uiState.asStateFlow()

    fun onCreate(eventId: Int) {
        getDetails(eventId = eventId)
    }

    private fun getDetails(eventId: Int) {
        viewModelScope.launch(CoroutineExceptionHandler { _, exception ->
            exception.localizedMessage?.let { Log.e("DetailsViewModel", it) }
        }) {
            getDogEventDetails(eventId = eventId).collect { dogEvent ->
                _uiState.update {
                    it.copy(
                        title = dogEvent.title,
                        subtitle = dogEvent.subtitle,
                        body = dogEvent.body,
                        category = dogEvent.category
                    )
                }
            }
        }
    }
}