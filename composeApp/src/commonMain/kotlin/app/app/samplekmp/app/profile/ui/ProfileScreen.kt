package app.app.samplekmp.app.profile.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.app.samplekmp.app.home.ui.HomeViewModel
import app.app.samplekmp.resources.composables.form.personalData.PersonalData
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun ProfileScreen(
    onBackClick: () -> Unit,
    onPersonalDataClick: () -> Unit,
    onDeleteAccountClick: () -> Unit,
    onLogoutClick: () -> Unit,
    profileViewModel: ProfileViewModel = koinViewModel()
) {
    val profileUiModelState by profileViewModel.profileUiModelState.collectAsStateWithLifecycle()
    ProfileScaffold(
        profileUiModelState = profileUiModelState,
        onBackClick = onBackClick,
        onPersonalDataClick = onPersonalDataClick,
        onDeleteAccountClick = onDeleteAccountClick,
        onLogoutClick = onLogoutClick
    )
}
