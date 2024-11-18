package app.app.samplekmp.app.home.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
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
            HomeScreen(
                onClickItem = {
                    rootController.navigate(DetailScreenRoute(it))
                }
            )
        }

        composable<DetailScreenRoute> { backStackEntry ->
            val detailScreenRoute: DetailScreenRoute = backStackEntry.toRoute()
            DetailScreen(
                id = detailScreenRoute.id,
                onCloseClick = {
                    rootController.popBackStack()
                }
            )
        }
    }
}
