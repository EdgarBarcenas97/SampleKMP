package app.app.samplekmp.app.profile.delete

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.app.samplekmp.resources.Space16
import app.app.samplekmp.resources.Space8
import app.app.samplekmp.resources.Weight1
import app.app.samplekmp.resources.composables.button.GradientButton
import app.app.samplekmp.resources.composables.topbar.TopBar
import samplekmp.composeapp.generated.resources.Res
import samplekmp.composeapp.generated.resources.delete_account
import samplekmp.composeapp.generated.resources.start_deleting_your_account_in_the_app

@Composable
fun DeleteAccountScaffold(
    onCloseClick: () -> Unit,
    onStartDeletingClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                title = Res.string.delete_account,
                icon = Icons.Default.Close,
                onBackClick = onCloseClick
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            Spacer(modifier = Modifier.height(Space8))
            Text(
                text = "Deleting your account and all data",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = Space16, vertical = Space8)
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = Space16, vertical = Space8)
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = Space8))
            Text(
                text = "Deleting an account in the app",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = Space16, vertical = Space8)
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = Space16, vertical = Space8)
            )
            Text(
                text = "You will receive confirmation of deleting your account in the application by e-mail",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = Space16, vertical = Space8)
            )
            Spacer(modifier = Modifier.weight(Weight1))
            GradientButton(
                title = Res.string.start_deleting_your_account_in_the_app,
                onButtonPressed = onStartDeletingClick,
                modifier = Modifier.padding(horizontal = Space16)
            )
        }
    }
}
