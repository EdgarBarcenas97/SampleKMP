package app.app.samplekmp.app.auth.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import app.app.samplekmp.app.auth.data.LOGIN_KEY
import app.app.samplekmp.app.auth.data.PASSWORD_KEY
import app.app.samplekmp.resources.Space16
import app.app.samplekmp.resources.Weight1
import app.app.samplekmp.resources.composables.button.GradientButton
import app.app.samplekmp.resources.composables.form.personalData.PersonalData
import app.app.samplekmp.resources.composables.form.registration.RegistrationForm
import app.app.samplekmp.resources.composables.form.registration.rememberRegistrationFormState
import app.app.samplekmp.resources.composables.topbar.TopBar
import com.russhwolf.settings.set
import samplekmp.composeapp.generated.resources.Res
import samplekmp.composeapp.generated.resources.register

@Composable
fun SignUpScaffold(
    onBackClick: () -> Unit,
    onRegisterClick: (personalData: PersonalData, password: String) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                title = Res.string.register,
                icon = Icons.Default.ArrowBack,
                onBackClick = onBackClick
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding(),
                    start = Space16,
                    end = Space16)
                .verticalScroll(rememberScrollState())
        ) {
            val formState = rememberRegistrationFormState()
            LaunchedEffect(Unit) {
                formState.personalData.run {
                    firstName.value = "Daniel"
                    lastName.value = "Barcenas"
                    email.onValueChanged("speedymovil")
                    phoneNumber.value = "2281032147"
                }
                formState.passwords.run {
                    firstPassword.onValueChanged("speedymovil2024")
                    secondPassword.onValueChanged("speedymovil2024")
                }
            }
            RegistrationForm(
                state = formState,
                modifier = Modifier.padding(top = Space16)
            )
            Spacer(modifier = Modifier.weight(Weight1))
            GradientButton(
                title = Res.string.register,
                enabledButton = formState.isValid,
                modifier = Modifier
                    .padding(bottom = Space16),
                onButtonPressed = {
                    onRegisterClick(
                        formState.personalData.personalData,
                        formState.passwords.firstPassword.value
                    )
                }
            )
        }
    }
}
