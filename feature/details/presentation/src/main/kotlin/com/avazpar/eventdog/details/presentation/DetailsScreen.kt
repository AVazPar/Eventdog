package com.avazpar.eventdog.details.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.getViewModel

private const val launchKey: String = "DetailsScreen"

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLifecycleComposeApi::class)
@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    viewModel: DetailsViewModel = getViewModel(),
) {
    val uiState: DetailsUIState by viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = {
            DetailsContent(
                title = uiState.title,
                modifier = modifier.padding(it)
            )
        })
}

@Composable
fun DetailsContent(
    title: String,
    modifier: Modifier = Modifier
) = Text(text = "Hello $title")