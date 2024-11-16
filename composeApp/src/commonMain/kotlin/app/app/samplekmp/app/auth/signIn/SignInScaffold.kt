package app.app.samplekmp.app.auth.signIn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.app.samplekmp.resources.RhealPrimary
import app.app.samplekmp.resources.Space16
import app.app.samplekmp.resources.Space48
import app.app.samplekmp.resources.Space64
import app.app.samplekmp.resources.Space8
import app.app.samplekmp.resources.composables.button.GradientButton
import app.app.samplekmp.resources.composables.button.TextButtonCustom
import app.app.samplekmp.resources.composables.form.login.LoginForm
import app.app.samplekmp.resources.composables.form.login.rememberLoginFormState
import app.app.samplekmp.resources.composables.topbar.TopBar
import org.jetbrains.compose.resources.stringResource
import samplekmp.composeapp.generated.resources.Res
import samplekmp.composeapp.generated.resources.forgot_password
import samplekmp.composeapp.generated.resources.login
import samplekmp.composeapp.generated.resources.register

@Composable
fun SignInScaffold(
    onBackClick: () -> Unit,
    onLoginClick: (email: String, password: String) -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                icon = Icons.Default.ArrowBack,
                onBackClick = onBackClick
            )
        }
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding(),
                    start = Space16,
                    end = Space16)
        ) {
            val formState = rememberLoginFormState()
            Text(
                text = stringResource(Res.string.login),
                style = MaterialTheme.typography.displayMedium
            )
            Spacer(modifier = Modifier.height(Space64))
            LoginForm(state = formState)
            TextButtonCustom(
                onTextButtonClick = onForgotPasswordClick,
                title = Res.string.forgot_password,
                color = RhealPrimary,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = Space8)
            )
            Spacer(modifier = Modifier.height(Space48))
            GradientButton(
                title = Res.string.login,
                onButtonPressed = {
                    onLoginClick(formState.email.value, formState.password.value)
                }
            )
            Spacer(modifier = Modifier.height(Space16))
            GradientButton(
                title = Res.string.register,
                onButtonPressed = onRegisterClick,
            )
        }
    }
}