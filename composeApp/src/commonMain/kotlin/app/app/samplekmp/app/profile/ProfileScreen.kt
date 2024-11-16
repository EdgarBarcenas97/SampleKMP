package app.app.samplekmp.app.profile

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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.app.samplekmp.resources.composables.form.personalData.PersonalData
import org.jetbrains.compose.resources.stringResource
import samplekmp.composeapp.generated.resources.Res
import samplekmp.composeapp.generated.resources.delete_account
import samplekmp.composeapp.generated.resources.logout
import samplekmp.composeapp.generated.resources.profile

@Composable
fun ProfileScreen(
    personalData: PersonalData,
    onBackClick: () -> Unit,
    onPersonalDataClick: () -> Unit,
    onDeleteAccountClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    ProfileScaffold(
        personalData = personalData,
        onBackClick = onBackClick,
        onPersonalDataClick = onPersonalDataClick,
        onDeleteAccountClick = onDeleteAccountClick,
        onLogoutClick = onLogoutClick
    )
}

@Composable
fun ProfileScaffold(
    personalData: PersonalData,
    onBackClick: () -> Unit,
    onPersonalDataClick: () -> Unit,
    onDeleteAccountClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(onBackClick)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            PersonalDataSection(personalData = personalData, onClick = onPersonalDataClick)
            HorizontalDivider()
            DeleteAccountItem(onClick = onDeleteAccountClick)
            LogoutItem(onClick = onLogoutClick)
        }
    }
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(onBackClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(Res.string.profile))
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
        }
    )
}

@Composable
private fun PersonalDataSection(personalData: PersonalData, onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            Text(
                text = "${personalData.firstName} ${personalData.lastName}",
                style = MaterialTheme.typography.titleLarge
            )
            Text(text = personalData.email, style = MaterialTheme.typography.bodyMedium)
            Text(
                text = personalData.phoneNumber,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
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
private fun LogoutItem(onClick: () -> Unit) {
    MyDataItem(text = stringResource(Res.string.logout), onClick = onClick)
}

@Composable
private fun MyDataItem(text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = text, style = MaterialTheme.typography.bodyLarge)
        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
    }
    HorizontalDivider()
}
