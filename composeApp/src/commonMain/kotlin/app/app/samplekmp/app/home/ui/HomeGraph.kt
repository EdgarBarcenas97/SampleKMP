package app.app.samplekmp.app.home.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import app.app.samplekmp.app.home.ui.detail.DetailScreen
import app.app.samplekmp.app.home.ui.detail.DetailScreenRoute
import app.app.samplekmp.app.main.BottomNavRoutes

fun NavGraphBuilder.homeGraph(
    rootController: NavHostController
) {
    navigation<BottomNavRoutes.HomeGraph>(
        startDestination = BottomNavRoutes.HomeScreenRoute
    ) {
        composable<BottomNavRoutes.HomeScreenRoute> {
            HomeScreen()
        }

        composable<DetailScreenRoute> {
            DetailScreen(
                onCloseClick = {
                    rootController.popBackStack()
                }
            )
        }
    }
}
