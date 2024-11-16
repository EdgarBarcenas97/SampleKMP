package app.app.samplekmp.app.home

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import samplekmp.composeapp.generated.resources.Res
import samplekmp.composeapp.generated.resources.chat
import samplekmp.composeapp.generated.resources.ic_chat
import samplekmp.composeapp.generated.resources.ic_chat_fill
import samplekmp.composeapp.generated.resources.ic_profile
import samplekmp.composeapp.generated.resources.ic_profile_fill
import samplekmp.composeapp.generated.resources.profile

@Serializable
data object HomeGraph

sealed class BottomNavRoutes {

    @Serializable
    data object ChatGraph : BottomNavRoutes()

    @Serializable
    data object ChatScreenRoute : BottomNavRoutes()

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
    CHAT(Res.string.chat, Res.drawable.ic_chat_fill, Res.drawable.ic_chat, false, BottomNavRoutes.ChatScreenRoute),
    PROFILE(Res.string.profile, Res.drawable.ic_profile_fill, Res.drawable.ic_profile, false, BottomNavRoutes.ProfileScreenRoute)
}
