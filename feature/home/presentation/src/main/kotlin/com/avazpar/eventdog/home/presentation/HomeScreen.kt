package com.avazpar.eventdog.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.avazpar.designsystem.atoms.EventBody
import com.avazpar.designsystem.atoms.EventImage
import com.avazpar.designsystem.atoms.EventTitle
import com.avazpar.designsystem.foundations.Beige
import com.avazpar.designsystem.foundations.Brown
import com.avazpar.designsystem.foundations.OrangeLight
import com.avazpar.eventdog.home.domain.usecases.DogEvent
import org.koin.androidx.compose.getViewModel

private const val launchKey: String = "Home"

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetails: () -> Unit,
    // handleNavigation: (HomeNavigation) -> Unit,
    viewModel: HomeViewModel = getViewModel()
) {
    val uiState: HomeUIState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = launchKey) {
        viewModel.onCreate()
    }

    Scaffold(
        containerColor = Beige,
        topBar = { HomeTopAppBar() },
        modifier = Modifier.fillMaxSize(),
        content = {
            HomeContent(
                eventList = uiState.eventList,
                onItemClicked = {
                    navigateToDetails()
                },
                modifier = modifier.padding(it)
            )
        })
}

@Composable
fun HomeContent(
    eventList: List<DogEvent>,
    onItemClicked: () -> Unit,
    modifier: Modifier = Modifier
) = LazyColumn(modifier = modifier) {
    item {
        Image(
            painter = painterResource(R.drawable.image_cover),
            contentDescription = "hola",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = stringResource(id = R.string.home_title),
            style = MaterialTheme.typography.titleLarge,
            color = Brown,
            modifier = Modifier.padding(10.dp),
        )
    }
    items(
        items = eventList,
        key = { event -> event.id }
    ) { event ->
        Spacer(modifier = Modifier.size(10.dp))
        EventItem(post = event, navigateToDetails = { onItemClicked() })
    }
    item {
        Spacer(modifier = Modifier.size(10.dp))
    }
}

@Composable
fun EventItem(
    post: DogEvent,
    navigateToDetails: (String) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = OrangeLight),
        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = { navigateToDetails(post.id) })
        ) {
            EventImage(imageThumbId = R.drawable.post_3_thumb, modifier = Modifier.padding(16.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                EventTitle(title = post.title)
                EventBody(body = post.subtitle)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeTopAppBar(
    modifier: Modifier = Modifier,
    topAppBarState: TopAppBarState = rememberTopAppBarState(),
    scrollBehavior: TopAppBarScrollBehavior? =
        TopAppBarDefaults.enterAlwaysScrollBehavior(topAppBarState)
) {
    val title = stringResource(id = R.string.home_title)
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = OrangeLight),
        title = {
            Image(
                painter = painterResource(R.drawable.ic_jetnews_logo),
                contentDescription = title,
                contentScale = ContentScale.Fit,
                modifier = Modifier.defaultMinSize()
            )
        },
        scrollBehavior = scrollBehavior,
        modifier = modifier
    )
}
