package co.kr.tnt.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import co.kr.tnt.home.HomeRoute
import co.kr.tnt.navigation.Route

fun NavController.navigateToHome(
    isTrainer: Boolean,
    navOptions: NavOptions? = null,
) = navigate(
    route = Route.Home(isTrainer),
    navOptions = navOptions,
)

fun NavGraphBuilder.homeNavGraph(
    homeDestination: NavGraphBuilder.() -> Unit,
) {
    navigation<Route.HomeBase>(startDestination = Route.Home(true)) {
        composable<Route.Home> { backstackEntry ->
            backstackEntry.toRoute<Route.Signup>().apply {
                HomeRoute(
                    isTrainer = isTrainer
                )
            }
        }
        homeDestination()
    }
}
