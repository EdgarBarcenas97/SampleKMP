package app.app.samplekmp.app.profile.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import app.app.samplekmp.app.main.BottomNavRoutes
import app.app.samplekmp.resources.composables.form.personalData.PersonalData
import app.app.samplekmp.app.profile.ui.delete.DeleteAccountScreen
import app.app.samplekmp.app.profile.ui.delete.DeleteAccountScreenRoute

fun NavGraphBuilder.profileGraph(
    rootController: NavHostController
) {
    navigation<BottomNavRoutes.ProfileGraph>(
        startDestination = BottomNavRoutes.ProfileScreenRoute
    ) {
        composable<BottomNavRoutes.ProfileScreenRoute> {
            ProfileScreen(
                personalData = PersonalData(
                    firstName = "John",
                    lastName = "Doe",
                    email = "john.doe@gmail.com",
                    phoneNumber = "+48 123 456 789",
                ),
                onBackClick = {
                    rootController.popBackStack()
                },
                onLogoutClick = {

                },
                onDeleteAccountClick = {
                    rootController.navigate(DeleteAccountScreenRoute)
                },
                onPersonalDataClick = {

                }
            )
        }

        composable<DeleteAccountScreenRoute> {
            DeleteAccountScreen(
                onCloseClick = {
                    rootController.popBackStack()
                },
                onStartDeletingClick = {

                }
            )
        }
    }
}
