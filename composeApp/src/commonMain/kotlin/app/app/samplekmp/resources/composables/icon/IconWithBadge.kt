package app.app.samplekmp.resources.composables.icon

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import app.app.samplekmp.app.home.BottomNavigation

@Composable
fun IconWithBadge(
    isSelected: Boolean,
    navigationItem: BottomNavigation,
) = navigationItem.run {
    BadgedBox(
        badge = {
            if (badgeCount != null) {
                Badge {
                    Text(text = badgeCount.toString())
                }
            } else if (hasNews) {
                Badge()
            }
        }
    ) {
        IconDrawable(
            drawableId = if (isSelected) {
                selectedIcon
            } else {
                unselectedIcon
            }
        )
    }
}