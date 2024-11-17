package app.app.samplekmp.app.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import app.app.samplekmp.app.auth.onboarding.OnboardingScreen
import app.app.samplekmp.app.main.MainGraph
import app.app.samplekmp.app.auth.signIn.SignInScreen
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
            OnboardingScreen(
                onSignInClick = { rootController.navigate(SignInScreenRoute) },
                onSignUpClick = { rootController.navigate(SignUpScreenRoute) }
            )
        }
        composable<SignInScreenRoute> {
            SignInScreen(
                onBackClick = { rootController.popBackStack() },
                onLoginClick = { email, password ->
                    rootController.navigate(MainGraph) {
                        popUpTo(rootController.graph.id) {
                            inclusive = true
                        }
                    }
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
                onRegisterClick = { email, password ->
                    signUpViewModel.setInitialData()
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
