package app.app.samplekmp.app.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.app.samplekmp.app.profile.ui.ProfileUiModelState
import app.app.samplekmp.core.extensions.orDefault
import app.app.samplekmp.resources.Space16
import app.app.samplekmp.resources.Space24
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = koinViewModel(),
    onClickItem: (String, String, String, String, Int) -> Unit
) {
    val tracksModelsStateUi = homeViewModel.tracksModelsStateUi.collectAsStateWithLifecycle()
    val profileUiModelState by homeViewModel.profileUiModelState.collectAsStateWithLifecycle()
    HomeScaffold(
        profileUiModelState,
        tracksModelsStateUi = tracksModelsStateUi.value,
        onClickItem = onClickItem,
        modifier = Modifier
    )
}

@Composable
fun HomeScaffold(
    profileUiModelState: ProfileUiModelState,
    tracksModelsStateUi: TracksModelsStateUi,
    onClickItem: (String, String, String, String, Int) -> Unit,
    modifier: Modifier = Modifier
) = tracksModelsStateUi.run {
    Scaffold(
        topBar = {
            profileUiModelState.user?.run {
                HeaderHome(
                    name = "$firstName $lastName",
                    image = "https://images.unsplash.com/photo-1535468850893-d6e543fbd7f5",
                    message = "Bienvenido a tu cuenta $email"
                )
            }
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
                contentPadding = PaddingValues(Space16),
                verticalArrangement = Arrangement.spacedBy(Space24)
            ) {
                items(it.tracks) { item ->
                    TrackItem(track = item, onClickItem = onClickItem)
                }
            }
        }
    }
}