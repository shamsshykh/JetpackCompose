package com.example.jetpacklearning.navigation
import kotlinx.serialization.Serializable

@Serializable
sealed interface AppGraph
@Serializable
data object AuthGraph : AppGraph
@Serializable
data object MainGraph : AppGraph

// ---------- Auth Screens ----------
@Serializable
sealed interface AuthRoute

@Serializable
data object LoginRoute : AuthRoute

@Serializable
data object RegisterRoute : AuthRoute

@Serializable
data object ForgotRoute : AuthRoute

// ---------- Main Screens ----------
@Serializable
sealed interface MainRoute

@Serializable
data object HomeRoute : MainRoute

@Serializable
data object ShoppingRoute : MainRoute

@Serializable
data object NotificationsRoute : MainRoute

@Serializable
data object ProfileRoute : MainRoute

@Serializable
data class DetailsRoute(
    val userId: String
) : MainRoute
