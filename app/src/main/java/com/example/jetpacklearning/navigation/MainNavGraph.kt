package com.example.jetpacklearning.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.jetpacklearning.MainScaffold
import com.example.jetpacklearning.compose.CardScreen
import com.example.jetpacklearning.compose.DetailsScreen
import com.example.jetpacklearning.compose.HomeScreen
import com.example.jetpacklearning.compose.NotificationsScreen
import com.example.jetpacklearning.compose.ProfileScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController
) {
    navigation<MainGraph>(
        startDestination = HomeRoute
    ) {

        composable<HomeRoute> {
            MainScaffold(navController) {
                HomeScreen(
                    onProfileClick = {
                        navController.navigate(ProfileRoute) {
                            popUpTo(HomeRoute) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    onDetailsClick = { userId ->
                        navController.navigate(DetailsRoute(userId))
                    }
                )
            }
        }

        composable<ProfileRoute> {
            MainScaffold(navController) {
                ProfileScreen(
                    onLogout = {
                        navController.navigate(AuthGraph) {
                            popUpTo(MainGraph) { inclusive = true }
                        }
                    }
                )
            }
        }

        composable<DetailsRoute> { entry ->
            val args = entry.toRoute<DetailsRoute>()
            DetailsScreen(
                userId = args.userId,
            )
        }


        composable<ShoppingRoute> {
            MainScaffold(navController) {
                CardScreen(onDetailsClick = { userId ->
                    navController.navigate(DetailsRoute(userId))
                })
            }
        }


        composable<NotificationsRoute> {
            MainScaffold(navController) {
                NotificationsScreen()
            }
        }
    }
}
