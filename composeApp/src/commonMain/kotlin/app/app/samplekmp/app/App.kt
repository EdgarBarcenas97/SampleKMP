package app.app.samplekmp.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.app.samplekmp.app.auth.AuthGraph
import app.app.samplekmp.app.auth.authGraph
import app.app.samplekmp.app.main.mainGraph
import app.app.samplekmp.resources.SampleTheme
import coil3.ImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import coil3.util.DebugLogger
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalCoilApi::class)
@Composable
fun App() {
    SampleTheme {
        setSingletonImageLoaderFactory { context ->
            ImageLoader.Builder(context)
                .crossfade(true)
                .logger(DebugLogger())
                .build()
        }
        RootGraph()
    }
}

@Composable
fun RootGraph() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val rootController = rememberNavController()
        NavHost(
            navController = rootController,
            startDestination = AuthGraph
        ) {
            authGraph(rootController)
            mainGraph(rootController)
        }
    }
}
