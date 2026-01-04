package com.example.jetpacklearning.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.jetpacklearning.compose.ChangeEmailScreen
import com.example.jetpacklearning.compose.ForgotPasswordScreen
import com.example.jetpacklearning.compose.LoginScreen
import com.example.jetpacklearning.compose.RegisterScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation<AuthGraph>(
        startDestination = LoginRoute
    ) {

        composable<LoginRoute>(
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) },
            popEnterTransition = { slideInHorizontally { it } },
            popExitTransition = { slideOutHorizontally { -it } }
        ) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(MainGraph) {
                        popUpTo(AuthGraph) { inclusive = true }
                    }
                },
                onForgotClick = {
                    navController.navigate(ForgotRoute)
                },
                onRegisterClick = {
                    navController.navigate(RegisterRoute)
                }
            )
        }

        composable<ForgotRoute> {
            ForgotPasswordScreen(
                onBack = { navController.popBackStack() }
            )
        }

        composable<RegisterRoute> {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(MainGraph) {
                        popUpTo(AuthGraph) { inclusive = true }
                    }
                }
            )
        }

        composable<EmailChangeRoute> {
            ChangeEmailScreen(
                onDone = { navController.popBackStack() }
            )
        }
    }
}
