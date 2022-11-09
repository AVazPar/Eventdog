package com.avazpar.eventdog.home.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed interface HomeNavigation {
    object ToDetails : HomeNavigation
}

data class HomeUIState(
    val title: Int = R.string.home_title,
    val body: Int = R.string.home_body,
    val navigation: HomeNavigation? = null
)

class HomeViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState = _uiState.asStateFlow()
}