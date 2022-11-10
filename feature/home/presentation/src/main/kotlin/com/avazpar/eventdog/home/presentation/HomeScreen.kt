package com.avazpar.eventdog.home.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.avazpar.designsystem.atoms.EventBody
import com.avazpar.designsystem.atoms.EventImage
import com.avazpar.designsystem.atoms.EventTitle
import com.avazpar.designsystem.foundations.Brown
import com.avazpar.designsystem.foundations.OrangeLight
import com.avazpar.eventdog.home.domain.usecases.DogEvent

private const val launchKey: String = "Home"

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    handleNavigation: (HomeNavigation) -> Unit,
    viewModel: HomeViewModel = HomeViewModel()
) {
    val uiState: HomeUIState by viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = {
            HomeContent(
                eventList = listOf(event2, event3),
                // onItemClicked = viewModel.onItemClicked(),
                modifier = modifier.padding(it)
            )

            uiState.navigation?.let { navigation ->
                LaunchedEffect(key1 = launchKey) {
                    handleNavigation(navigation)//.also { viewModel.processNavigation() }
                }
            }
        })
}

@Composable
fun HomeContent(
    eventList: List<DogEvent>,
    // onItemClicked: () -> Unit,
    modifier: Modifier = Modifier
) = LazyColumn(modifier = modifier) {
    item {
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
        EventItem(post = event, navigateToArticle = {})
    }
}

val event2 = DogEvent(
    id = "ac552dcc1742",
    title = "Perrotón race",
    subtitle = "Run with your dog in Madrid",
    imageId = R.drawable.post_3,
    imageThumbId = R.drawable.post_3_thumb
)

val event3 = DogEvent(
    id = "ac552dcc1741",
    title = "Perrotón race",
    subtitle = "Run with your dog in Madrid",
    imageId = R.drawable.post_3,
    imageThumbId = R.drawable.post_3_thumb
)

@Composable
fun EventItem(
    post: DogEvent,
    navigateToArticle: (String) -> Unit
) {
    Card(
        /*colors = CardColors(
            containerColor = OrangeLight,
            contentColor = OrangeLight,
            disabledContainerColor = OrangeLight,
            disabledContentColor = OrangeLight
        ),*/
        modifier = Modifier.padding(
            start = 10.dp, end = 10.dp
        )
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = { navigateToArticle(post.id) })
        ) {
            EventImage(imageThumbId = post.imageThumbId, modifier = Modifier.padding(16.dp))
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