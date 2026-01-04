package com.example.jetpacklearning.navigation
import kotlinx.serialization.Serializable


sealed interface RootRoute
@Serializable
data object AuthGraph : RootRoute
@Serializable
data object MainGraph : RootRoute


// Screens
@Serializable
sealed interface ScreenRoute
@Serializable data object LoginRoute : ScreenRoute
@Serializable data object ForgotRoute : ScreenRoute
@Serializable data object RegisterRoute : ScreenRoute
@Serializable data object EmailChangeRoute : ScreenRoute
@Serializable data object HomeRoute : ScreenRoute
@Serializable data object ProfileRoute : ScreenRoute
@Serializable
data class DetailsRoute(
    val userId: String
) : ScreenRoute
