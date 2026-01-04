package com.example.jetpacklearning.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavGraph(navController: NavHostController, isLoggedIn: Boolean, modifier: Modifier) {

    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) MainGraph else AuthGraph,
        modifier = modifier,
        enterTransition = { slideInHorizontally(animationSpec = tween(300)) + fadeIn() },
        exitTransition = { slideOutHorizontally(animationSpec = tween(300)) + fadeOut() },
        popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }) + fadeIn() },
        popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) + fadeOut() }
    ) {
        authNavGraph(navController)
        mainNavGraph(navController)
    }
}