package com.avazpar.eventdog.details.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.avazpar.designsystem.foundations.Brown
import com.avazpar.designsystem.foundations.OrangeLight
import org.koin.androidx.compose.getViewModel

private const val launchKey: String = "DetailsScreen"

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLifecycleComposeApi::class)
@Composable
fun DetailsScreen(
    eventId: String,
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    viewModel: DetailsViewModel = getViewModel(),
) {
    val uiState: DetailsUIState by viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(
        topBar = { DetailsTopAppBar(navigateToHome = { navigateToHome() }) },
        modifier = Modifier.fillMaxSize(),
        content = {
            DetailsContent(
                title = uiState.title + " " + eventId,
                modifier = modifier.padding(it)
            )
        })
}

@Composable
fun DetailsContent(
    title: String,
    modifier: Modifier = Modifier
) = LazyColumn(modifier = modifier) {
    item {
        Image(
            painter = painterResource(R.drawable.cover_1),
            contentDescription = "hola",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = title,//stringResource(id = R.string.details.),
            style = MaterialTheme.typography.titleLarge,
            color = Brown,
            modifier = Modifier.padding(10.dp),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailsTopAppBar(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    topAppBarState: TopAppBarState = rememberTopAppBarState(),
    scrollBehavior: TopAppBarScrollBehavior? =
        TopAppBarDefaults.enterAlwaysScrollBehavior(topAppBarState)
) {
    val title = stringResource(id = R.string.details_title)
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = OrangeLight),
        navigationIcon = {
            IconButton(onClick = { navigateToHome() }) {
                Icon(
                    painter = painterResource(R.drawable.ic_jetnews_logo),
                    contentDescription = title,
                    modifier = Modifier.defaultMinSize()
                )
            }
        },
        title = {},
        scrollBehavior = scrollBehavior,
        modifier = modifier
    )
}
