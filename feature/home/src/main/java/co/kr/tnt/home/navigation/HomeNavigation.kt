package co.kr.tnt.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import co.kr.tnt.home.HomeRoute
import co.kr.tnt.navigation.Route

fun NavController.navigateToHome(navOptions: NavOptions) = navigate(
    route = Route.Home,
    navOptions = navOptions,
)

fun NavGraphBuilder.homeNavGraph(
    homeDestination: NavGraphBuilder.() -> Unit,
) {
    navigation<Route.HomeBase>(startDestination = Route.Home) {
        composable<Route.Home> {
            HomeRoute()
        }
    }
    homeDestination()
}
