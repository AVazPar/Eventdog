package com.avazpar.eventdog.home.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.getViewModel

private const val launchKey: String = "Home"

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    handleNavigation: (HomeNavigation) -> Unit,
   // viewModel: HomeViewModel = getViewModel(),
) {
   // val uiState: HomeUIState by viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = {
            HomeContent(
                title = R.string.home_title,//uiState.title,
                body = R.string.home_title,//uiState.body,
                modifier = modifier.padding(it)
            )

           /* uiState.navigation?.let { navigation ->
                LaunchedEffect(key1 = launchKey) {
                    handleNavigation(navigation)//.also { viewModel.processNavigation() }
                }
            }*/
        })
}

@Composable
fun HomeContent(
    @StringRes title: Int,
    @StringRes body: Int,
    modifier: Modifier = Modifier
) = Text(text = "Hello " + stringResource(id = title))