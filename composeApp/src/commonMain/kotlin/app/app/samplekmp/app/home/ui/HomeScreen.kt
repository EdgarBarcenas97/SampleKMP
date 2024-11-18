package app.app.samplekmp.app.home.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.app.samplekmp.core.extensions.orDefault
import app.app.samplekmp.resources.Space16
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = koinViewModel()
) {
    val tracksModelsStateUi = homeViewModel.tracksModelsStateUi.collectAsStateWithLifecycle()
    HomeScaffold(
        tracksModelsStateUi = tracksModelsStateUi.value,
        modifier = Modifier
    )
}

@Composable
fun HomeScaffold(
    tracksModelsStateUi: TracksModelsStateUi,
    modifier: Modifier = Modifier
) = tracksModelsStateUi.run {
    Scaffold(
        topBar = {
            HeaderHome(
                name = "Daniel",
                image = "https://images.unsplash.com/photo-1535468850893-d6e543fbd7f5",
                message = "Bienvenido"
            )
        },
        modifier = modifier
    ) { padding ->
        tracksUi?.let {
            val listState = rememberLazyListState()
            LaunchedEffect(it.tracks.size) {
                listState.animateScrollToItem(it.tracks.size.orDefault())
            }
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = padding.calculateTopPadding()),
                contentPadding = PaddingValues(Space16)
            ) {
                items(it.tracks) { item ->
                    ChatItem(item)
                }
            }
        }
    }
}