package app.app.samplekmp.app.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.app.samplekmp.app.home.homeGraph
import app.app.samplekmp.app.main.ui.BottomNavigationBar
import app.app.samplekmp.app.profile.profileGraph

@Composable
fun MainScreen(
    rootController: NavHostController
) {
    val navigationBarController = rememberNavController()

    val showBottomBar = navigationBarController
        .currentBackStackEntryAsState().value?.destination?.route in BottomNavigation.entries.map { it.route::class.qualifiedName }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(navHostController = navigationBarController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navigationBarController,
            startDestination = BottomNavRoutes.HomeGraph,
            modifier = Modifier.padding(innerPadding)
        ) {
            homeGraph(rootController = rootController)
            profileGraph(rootController = navigationBarController)
        }
    }
}
