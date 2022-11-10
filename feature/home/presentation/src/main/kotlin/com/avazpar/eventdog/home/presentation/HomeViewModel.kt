package com.avazpar.eventdog.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avazpar.eventdog.home.domain.usecases.DogEvent
import com.avazpar.eventdog.home.domain.usecases.GetAllDogEvents
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface HomeNavigation {
    object ToDetails : HomeNavigation
}

data class HomeUIState(
    val title: Int = R.string.home_title,
    val body: Int = R.string.home_body,
    val eventList: List<DogEvent> = listOf(),
    val navigation: HomeNavigation? = null
)

class HomeViewModel(
  //  val getAllDogEvents: GetAllDogEvents
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState = _uiState.asStateFlow()

    fun getEventList() {
        viewModelScope.launch(CoroutineExceptionHandler { _, exception ->
            exception.localizedMessage?.let { Log.e("CloseAccountViewModel", it) }
        }) {
          /*  getAllDogEvents().collect { list ->
                _uiState.update { it.copy(eventList = list) }
            }*/
        }
    }

    fun onItemClicked() {
        _uiState.update { it.copy(navigation = HomeNavigation.ToDetails) }
    }
}