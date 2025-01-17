package co.kr.tnt.signup.common.role

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import co.kr.tnt.navigation.Route

fun NavController.navigateToRoleSelection(
    navOptions: NavOptionsBuilder.() -> Unit = {},
) = navigate(
    route = Route.RoleSelection,
    builder = navOptions,
)

fun NavGraphBuilder.roleSelectionScreen(
    navigateToSignup: (isTrainer: Boolean) -> Unit,
) {
    composable<Route.RoleSelection> {
        RoleSelectionScreen(navigateToSignup = navigateToSignup)
    }
}
