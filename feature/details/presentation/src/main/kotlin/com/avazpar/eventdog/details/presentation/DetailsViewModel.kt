package com.avazpar.eventdog.details.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class DetailsUIState(
    val title: String = "DETALLES"
)

class DetailsViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(DetailsUIState())
    val uiState = _uiState.asStateFlow()
}
