package app.app.samplekmp.app.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import app.app.samplekmp.app.auth.onboarding.OnboardingScreen
import app.app.samplekmp.app.home.HomeGraph
import app.app.samplekmp.app.auth.signIn.SignInScreen
import app.app.samplekmp.app.auth.signup.SignUpScreen
import kotlinx.serialization.Serializable

@Serializable
data object AuthGraph

@Serializable
data object OnboardingScreenRoute

@Serializable
data object SignInScreenRoute

@Serializable
data object SignUpScreenRoute

fun NavGraphBuilder.authGraph(
    rootController: NavHostController
) {
    navigation<AuthGraph>(
        startDestination = OnboardingScreenRoute
    ) {
        composable<OnboardingScreenRoute> {
            OnboardingScreen(
                onSignInClick = {
                    rootController.navigate(SignInScreenRoute)
                },
                onSignUpClick = {
                    rootController.navigate(SignUpScreenRoute)
                }
            )
        }
        composable<SignInScreenRoute> {
            SignInScreen(
                onBackClick = {
                    rootController.popBackStack()
                },
                onLoginClick = { email, password ->
                    rootController.navigate(HomeGraph) {
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
            SignUpScreen(
                onBackClick = {
                    rootController.popBackStack()
                },
                onRegisterClick = { email, password ->
                    rootController.navigate(HomeGraph) {
                        popUpTo(rootController.graph.id) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}