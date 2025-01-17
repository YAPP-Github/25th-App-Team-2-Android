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
    navigateToPrevious: () -> Unit
) {
    composable<Route.Signup> { backstackEntry ->
        backstackEntry.toRoute<Route.Signup>().apply {
            SignUpRoute(
                navigateToPrevious = navigateToPrevious,
                isTrainer = this.isTrainer,
            )
        }
    }
}
