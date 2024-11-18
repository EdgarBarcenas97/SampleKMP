package app.app.samplekmp.app.auth.signIn

import androidx.compose.runtime.Composable

@Composable
fun SignInScreen(
    onBackClick: () -> Unit,
    onLoginClick: (email: String, password: String) -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
) {
    SignInScaffold(
        onBackClick = onBackClick,
        onLoginClick = onLoginClick,
        onRegisterClick = onRegisterClick,
        onForgotPasswordClick = onForgotPasswordClick
    )
}
