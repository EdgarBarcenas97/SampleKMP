package app.app.samplekmp.app.home.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import app.app.samplekmp.app.home.BottomNavRoutes
import app.app.samplekmp.app.home.BottomNavigation
import app.app.samplekmp.core.extensions.one
import app.app.samplekmp.resources.RhealPrimary
import app.app.samplekmp.resources.composables.icon.IconWithBadge
import org.jetbrains.compose.resources.stringResource

@Composable
fun BottomNavigationBar(
    navHostController: NavHostController
) {

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: BottomNavRoutes.ChatGraph::class.qualifiedName.orEmpty()

    val currentRouteTrimmed by remember(currentRoute) {
        derivedStateOf { currentRoute.substringBefore("?") }
    }

    NavigationBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        BottomNavigation.entries.forEachIndexed { _, navigationItem ->

            val isSelected by remember(currentRoute) {
                derivedStateOf { currentRouteTrimmed == navigationItem.route::class.qualifiedName }
            }

            NavigationBarItem(
                selected = isSelected,
                label = {
                    Text(
                        text = stringResource(navigationItem.title),
                        maxLines = Int.one()
                    )
                },
                icon = {
                    IconWithBadge(
                        isSelected = isSelected,
                        navigationItem= navigationItem
                    )
                },
                onClick = {
                    navHostController.navigate(navigationItem.route) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(selectedIconColor = RhealPrimary)
            )
        }
    }
}
