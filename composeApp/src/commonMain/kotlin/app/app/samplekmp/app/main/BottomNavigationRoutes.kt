package app.app.samplekmp.app.main

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import samplekmp.composeapp.generated.resources.Res
import samplekmp.composeapp.generated.resources.chat
import samplekmp.composeapp.generated.resources.home
import samplekmp.composeapp.generated.resources.ic_chat
import samplekmp.composeapp.generated.resources.ic_chat_fill
import samplekmp.composeapp.generated.resources.ic_profile
import samplekmp.composeapp.generated.resources.ic_profile_fill
import samplekmp.composeapp.generated.resources.profile

@Serializable
data object MainGraph

sealed class BottomNavRoutes {

    @Serializable
    data object HomeGraph : BottomNavRoutes()

    @Serializable
    data object HomeScreenRoute : BottomNavRoutes()

    @Serializable
    data object ProfileGraph : BottomNavRoutes()

    @Serializable
    data object ProfileScreenRoute : BottomNavRoutes()
}

enum class BottomNavigation(
    val title: StringResource,
    val selectedIcon: DrawableResource,
    val unselectedIcon: DrawableResource,
    val hasNews: Boolean,
    val route: BottomNavRoutes,
    val badgeCount: Int? = null,
) {
    CHAT(Res.string.home, Res.drawable.ic_chat_fill, Res.drawable.ic_chat, false, BottomNavRoutes.HomeScreenRoute),
    PROFILE(Res.string.profile, Res.drawable.ic_profile_fill, Res.drawable.ic_profile, false, BottomNavRoutes.ProfileScreenRoute)
}
