package app.app.samplekmp.app.home.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = koinViewModel()
) {
    Text("Home ")
}

