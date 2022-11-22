package com.avazpar.eventdog.home.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.avazpar.designsystem.foundations.Beige
import com.avazpar.designsystem.foundations.Brown
import com.avazpar.designsystem.foundations.OrangeLight
import com.avazpar.eventdog.home.domain.usecases.DogEventCategory
import com.avazpar.eventdog.home.presentation.*
import com.avazpar.eventdog.home.presentation.R
import org.koin.androidx.compose.getViewModel

private const val launchKey: String = "DetailsScreen"

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLifecycleComposeApi::class)
@Composable
fun DetailsScreen(
    eventId: Int,
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    viewModel: DetailsViewModel = getViewModel(),
) {
    val uiState: DetailsUIState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = launchKey) {
        viewModel.onCreate(eventId)
    }

    Scaffold(
        containerColor = Beige,
        topBar = { DetailsTopAppBar(navigateToHome = { navigateToHome() }) },
        modifier = Modifier.fillMaxSize(),
        content = {
            DetailsContent(
                title = uiState.title,
                subtitle = uiState.subtitle,
                body = uiState.body,
                category = uiState.category,
                modifier = modifier.padding(it)
            )
        })
}

@Composable
fun DetailsContent(
    title: String,
    subtitle: String,
    body: String,
    category: DogEventCategory,
    modifier: Modifier = Modifier
) = LazyColumn(modifier = modifier) {
    item {
        Image(
            painter = painterResource(getCoverFromCategory(category = category)),
            contentDescription = stringResource(id = R.string.details_title),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = Brown,
            modifier = Modifier.padding(10.dp),
        )
        val date = subtitle.toDate(format = TIMESTAMP_ISO_STRING_PATTERN)
        date?.let {
            Text(
                text = "Day: " + it.toFormatDateString(),
                style = MaterialTheme.typography.titleMedium,
                color = Brown,
                modifier = Modifier.padding(start = 10.dp),
            )
            Text(
                text = "Hour: " + it.toFormatHourString(),
                style = MaterialTheme.typography.titleMedium,
                color = Brown,
                modifier = Modifier.padding(start = 10.dp),
            )
        }
        Text(
            text = body,
            style = MaterialTheme.typography.titleSmall,
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
                    painter = painterResource(R.drawable.ic_arrow_left),
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


private fun getCoverFromCategory(category: DogEventCategory): Int =
    when(category){
        DogEventCategory.SPORT -> R.drawable.cover_1
        DogEventCategory.FOOD -> R.drawable.cover_2
        DogEventCategory.HEALTH -> R.drawable.cover_3
        DogEventCategory.SOCIAL -> R.drawable.cover_4
        else -> R.drawable.cover_5
    }
