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
                onClickItem = { name, posterUrl, albumName, artistName, numTracks ->
                    rootController.navigate(
                        DetailScreenRoute(
                            name = name,
                            posterUrl = posterUrl,
                            albumName = albumName,
                            artistName = artistName,
                            numTracks = numTracks
                        )
                    )
                }
            )
        }

        composable<DetailScreenRoute> { backStackEntry ->
            val detailScreenRoute: DetailScreenRoute = backStackEntry.toRoute()
            DetailScreen(
                name = detailScreenRoute.name,
                posterUrl = detailScreenRoute.posterUrl,
                albumName = detailScreenRoute.albumName,
                artistName = detailScreenRoute.artistName,
                numTracks = detailScreenRoute.numTracks,
                onCloseClick = {
                    rootController.popBackStack()
                }
            )
        }
    }
}
