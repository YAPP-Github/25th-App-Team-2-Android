package co.kr.tnt.connect.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import co.kr.tnt.connect.ConnectRoute
import co.kr.tnt.connect.PTSessionFormScreen
import co.kr.tnt.navigation.Route

fun NavController.navigateToConnect(
    isTrainer: Boolean,
    navOptions: NavOptionsBuilder.() -> Unit = {},
) = navigate(
    route = Route.Connect(isTrainer),
    builder = navOptions,
)

fun NavGraphBuilder.connectScreen(
    navigateToPrevious: () -> Unit,
    navigateToHome: (Boolean) -> Unit,
) {
    composable<Route.Connect> { backstackEntry ->
        backstackEntry.toRoute<Route.Connect>().apply {
            ConnectRoute(
                isTrainer = this.isTrainer,
                navigateToPrevious = navigateToPrevious,
                navigateToHome = navigateToHome,
            )
        }
    }
}

fun NavController.navigateToPTSeesionForm(
    navOptions: NavOptionsBuilder.() -> Unit = {},
) = navigate(
    route = Route.PTSessionForm,
    builder = navOptions,
)

fun NavGraphBuilder.ptSessionFormScreen(
    navigateToHome: (Boolean) -> Unit,
) {
    composable<Route.PTSessionForm> { backstackEntry ->
        backstackEntry.toRoute<Route.PTSessionForm>().apply {
            PTSessionFormScreen(
                onNextClick = {
                    navigateToHome(false)
                }
            )
        }
    }
}
