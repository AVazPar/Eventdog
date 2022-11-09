package com.avazpar.eventdog.details.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed interface DetailsNavigation {
    object ToBack : DetailsNavigation
}

data class DetailsUIState(
    val title: String = "DETALLES",
    val navigation: DetailsNavigation? = null
)

class DetailsViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(DetailsUIState())
    val uiState = _uiState.asStateFlow()
}
