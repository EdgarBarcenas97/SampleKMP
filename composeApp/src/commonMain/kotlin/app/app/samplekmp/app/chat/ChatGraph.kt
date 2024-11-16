package app.app.samplekmp.app.chat

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import app.app.samplekmp.app.home.BottomNavRoutes

fun NavGraphBuilder.chatGraph(
    rootController: NavHostController
) {
    navigation<BottomNavRoutes.ChatGraph>(
        startDestination = BottomNavRoutes.ChatScreenRoute
    ) {
        composable<BottomNavRoutes.ChatScreenRoute> {
            ChatScreen()
        }
    }
}
