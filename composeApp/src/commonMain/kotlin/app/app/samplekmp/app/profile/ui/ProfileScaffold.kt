package app.app.samplekmp.app.profile.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.app.samplekmp.app.profile.domain.User
import app.app.samplekmp.resources.Space16
import app.app.samplekmp.resources.Space64
import app.app.samplekmp.resources.Space8
import app.app.samplekmp.resources.composables.topbar.TopBar
import org.jetbrains.compose.resources.stringResource
import samplekmp.composeapp.generated.resources.Res
import samplekmp.composeapp.generated.resources.delete_account
import samplekmp.composeapp.generated.resources.logout
import samplekmp.composeapp.generated.resources.profile

@Composable
fun ProfileScaffold(
    profileUiModelState: ProfileUiModelState,
    onBackClick: () -> Unit,
    onPersonalDataClick: () -> Unit,
    onDeleteAccountClick: () -> Unit,
    onLogoutClick: () -> Unit
) = profileUiModelState.run {
    Scaffold(
        topBar = {
            TopBar(
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                title = Res.string.profile,
                onBackClick = onBackClick
            )
        }
    ) { padding ->
        if (user != null) {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                PersonalDataSection(user = user, onClick = onPersonalDataClick)
                HorizontalDivider()
                DeleteAccountItem(onClick = onDeleteAccountClick)
                LogoutItem(onClick = onLogoutClick)
            }
        }
    }
}

@Composable
private fun PersonalDataSection(user: User, onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(Space16),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(Space8)) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = Modifier.size(Space64)
            )
            Text(
                text = "${user.firstName} ${user.lastName}",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = user.email,
                style = MaterialTheme.typography.bodyMedium)
            Text(
                text = user.phoneNumber,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = null
        )
    }
}

@Composable
private fun DeleteAccountItem(onClick: () -> Unit) {
    MyDataItem(
        text = stringResource(Res.string.delete_account),
        onClick = onClick
    )
}

@Composable
private fun LogoutItem(
    onClick: () -> Unit
) {
    MyDataItem(
        text = stringResource(Res.string.logout),
        onClick = onClick
    )
}

@Composable
private fun MyDataItem(
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(Space16),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge
        )
        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = null
        )
    }
    HorizontalDivider()
}
