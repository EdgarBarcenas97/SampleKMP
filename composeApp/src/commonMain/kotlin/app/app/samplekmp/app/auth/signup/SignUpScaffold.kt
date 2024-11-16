package app.app.samplekmp.app.auth.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import app.app.samplekmp.resources.Space16
import app.app.samplekmp.resources.Weight1
import app.app.samplekmp.resources.composables.topbar.TopBar
import app.app.samplekmp.resources.composables.form.personalData.PersonalData
import app.app.samplekmp.resources.composables.form.registration.RegistrationForm
import app.app.samplekmp.resources.composables.form.registration.rememberRegistrationFormState
import org.jetbrains.compose.resources.stringResource
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
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            val formState = rememberRegistrationFormState()

            LaunchedEffect(Unit) {
                formState.personalData.run {
                    firstName.value = "John"
                    lastName.value = "Doe"
                    email.onValueChanged("john.doe@gmail.com")
                    phoneNumber.value = "123456789"
                }
                formState.passwords.run {
                    firstPassword.onValueChanged("StrongPassword123")
                    secondPassword.onValueChanged("StrongPassword123")
                }
            }

            RegistrationForm(
                state = formState,
                modifier = Modifier.padding(Space16)
            )
            Spacer(modifier = Modifier.weight(Weight1))
            Button(
                onClick = {
                    onRegisterClick(
                        formState.personalData.personalData,
                        formState.passwords.firstPassword.value
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Space16),
                enabled = formState.isValid,
            ) {
                Text(text = stringResource(Res.string.register))
            }
        }
    }
}
