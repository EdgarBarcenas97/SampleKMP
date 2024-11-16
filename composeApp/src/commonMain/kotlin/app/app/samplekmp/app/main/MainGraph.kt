package app.app.samplekmp.app.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

fun NavGraphBuilder.mainGraph(
    rootController: NavHostController
) {
    composable<MainGraph> {
        MainScreen(rootController = rootController)
    }
}