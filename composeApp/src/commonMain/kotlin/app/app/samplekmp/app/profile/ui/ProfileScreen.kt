package app.app.samplekmp.app.profile.ui

import androidx.compose.runtime.Composable
import app.app.samplekmp.resources.composables.form.personalData.PersonalData

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
