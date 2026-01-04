package com.example.jetpacklearning.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.jetpacklearning.compose.DetailsScreen
import com.example.jetpacklearning.compose.HomeScreen
import com.example.jetpacklearning.compose.ProfileScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController
) {
    navigation<MainGraph>(
        startDestination = HomeRoute
    ) {

        composable<HomeRoute> {
            HomeScreen(
                onProfileClick = {
                    navController.navigate(ProfileRoute)
                },
                onDetailsClick = { userId ->
                    navController.navigate(
                        DetailsRoute(userId)
                    )
                }
            )
        }

        composable<ProfileRoute> {
            ProfileScreen(
                onLogout = {
                    navController.navigate(AuthGraph) {
                        popUpTo(MainGraph) { inclusive = true }
                    }
                }
            )
        }

        composable<DetailsRoute> { entry ->
            val args = entry.toRoute<DetailsRoute>()
            DetailsScreen(
                userId = args.userId,
            )
        }
    }
}
