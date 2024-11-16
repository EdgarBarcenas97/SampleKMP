package app.app.samplekmp.app.auth.signIn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.app.samplekmp.resources.Space16
import app.app.samplekmp.resources.Space24
import app.app.samplekmp.resources.Space48
import app.app.samplekmp.resources.Space64
import app.app.samplekmp.resources.Space8
import app.app.samplekmp.resources.composables.form.login.LoginForm
import app.app.samplekmp.resources.composables.form.login.rememberLoginFormState
import org.jetbrains.compose.resources.stringResource
import samplekmp.composeapp.generated.resources.Res
import samplekmp.composeapp.generated.resources.forgot_password
import samplekmp.composeapp.generated.resources.login
import samplekmp.composeapp.generated.resources.register

@Composable
fun SignInScreen(
    onBackClick: () -> Unit,
    onLoginClick: (email: String, password: String) -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    SignInScaffold(
        onBackClick = onBackClick,
        onLoginClick = onLoginClick,
        onRegisterClick = onRegisterClick,
        onForgotPasswordClick = onForgotPasswordClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScaffold(
    onBackClick: () -> Unit,
    onLoginClick: (email: String, password: String) -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val formState = rememberLoginFormState()

            Text(
                text = stringResource(Res.string.login),
                style = MaterialTheme.typography.displayMedium
            )
            Spacer(modifier = Modifier.height(Space64))
            LoginForm(
                state = formState,
                modifier = Modifier.padding(horizontal = Space24)
            )
            TextButton(
                onClick = onForgotPasswordClick,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = Space16, top = Space8)
            ) {
                Text(text = stringResource(Res.string.forgot_password))
            }
            Spacer(modifier = Modifier.height(Space48))
            Button(
                onClick = {
                    onLoginClick(formState.email.value, formState.password.value)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Space24),
                enabled = formState.isValid,
            ) {
                Text(text = stringResource(Res.string.login))
            }
            Spacer(modifier = Modifier.height(Space8))
            OutlinedButton(
                onClick = onRegisterClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Space24)
            ) {
                Text(text = stringResource(Res.string.register))
            }
        }
    }
}
