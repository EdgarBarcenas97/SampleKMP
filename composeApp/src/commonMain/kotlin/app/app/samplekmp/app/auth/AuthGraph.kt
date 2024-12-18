package app.app.samplekmp.app.auth

import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import app.app.samplekmp.app.auth.onboarding.OnboardingScreen
import app.app.samplekmp.app.auth.onboarding.OnboardingViewModel
import app.app.samplekmp.app.main.MainGraph
import app.app.samplekmp.app.auth.signIn.SignInScreen
import app.app.samplekmp.app.auth.signIn.SignInViewModel
import app.app.samplekmp.app.auth.signup.SignUpScreen
import app.app.samplekmp.app.auth.signup.SignUpViewModel
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Serializable
data object AuthGraph

@Serializable
data object OnboardingScreenRoute

@Serializable
data object SignInScreenRoute

@Serializable
data object SignUpScreenRoute

@OptIn(KoinExperimentalAPI::class)
fun NavGraphBuilder.authGraph(
    rootController: NavHostController
) {
    navigation<AuthGraph>(
        startDestination = OnboardingScreenRoute
    ) {
        composable<OnboardingScreenRoute> {
            val onboardingViewModel: OnboardingViewModel = koinViewModel()
            val isInitSessionUiState = onboardingViewModel.isInitSessionUiState.collectAsStateWithLifecycle()
            if (isInitSessionUiState.value) {
                rootController.navigate(MainGraph) {
                    popUpTo(rootController.graph.id) {
                        inclusive = true
                    }
                }
            } else {
                OnboardingScreen(
                    onSignInClick = { rootController.navigate(SignInScreenRoute) },
                    onSignUpClick = { rootController.navigate(SignUpScreenRoute) }
                )
            }

        }
        composable<SignInScreenRoute> {
            val signInViewModel: SignInViewModel = koinViewModel()
            val isNavigate = signInViewModel.isNavigate

            if (isNavigate) {
                LaunchedEffect(Unit) {
                    rootController.navigate(MainGraph) {
                        popUpTo(rootController.graph.id) {
                            inclusive = true
                        }
                    }
                }
            }
            SignInScreen(
                onBackClick = { rootController.popBackStack() },
                onLoginClick = { email, password ->
                    signInViewModel.login(email, password)
                },
                onRegisterClick = {
                    rootController.navigate(SignUpScreenRoute)
                },
                onForgotPasswordClick = { }
            )
        }
        composable<SignUpScreenRoute> {
            val signUpViewModel: SignUpViewModel = koinViewModel()
            SignUpScreen(
                onBackClick = { rootController.popBackStack() },
                onRegisterClick = { data, password ->
                    signUpViewModel.signup(data, password)
                    rootController.navigate(MainGraph) {
                        popUpTo(rootController.graph.id) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}
