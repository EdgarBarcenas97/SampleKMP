package app.app.samplekmp.resources.composables.topbar

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar(
    title: StringResource? = null,
    icon: ImageVector? = null,
    onBackClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            if (title != null)
                Text(text = stringResource(title))
        },
        navigationIcon = {
            if (icon != null) {
                IconButton(onClick = onBackClick) {
                    Icon(imageVector = icon, contentDescription = null)
                }
            }
        }
    )
}
