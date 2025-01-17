package co.kr.tnt.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object HomeBase : Route

    @Serializable
    data object Home : Route

    @Serializable
    data object Login : Route

    @Serializable
    data object RoleSelection : Route

    @Serializable
    data class Signup(val isTrainer: Boolean) : Route
}
