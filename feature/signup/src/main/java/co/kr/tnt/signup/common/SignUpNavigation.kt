package co.kr.tnt.signup.common

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import co.kr.tnt.navigation.Route

fun NavController.navigateToSignup(
    isTrainer: Boolean,
    navOptions: NavOptionsBuilder.() -> Unit = {},
) = navigate(
    route = Route.Signup(isTrainer),
    builder = navOptions,
)

fun NavGraphBuilder.signupScreen(
    navigateToConnect: (isTrainer: Boolean) -> Unit,
    navigateToPrevious: () -> Unit,
) {
    composable<Route.Signup> { backstackEntry ->
        backstackEntry.toRoute<Route.Signup>().apply {
            SignUpRoute(
                isTrainer = this.isTrainer,
                navigateToConnect = { navigateToConnect(this.isTrainer) },
                navigateToPrevious = navigateToPrevious,
            )
        }
    }
}
