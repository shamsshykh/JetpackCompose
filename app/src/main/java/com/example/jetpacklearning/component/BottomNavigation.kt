package com.example.jetpacklearning.component

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jetpacklearning.navigation.HomeRoute
import com.example.jetpacklearning.navigation.MainRoute
import com.example.jetpacklearning.navigation.NotificationsRoute
import com.example.jetpacklearning.navigation.ProfileRoute
import com.example.jetpacklearning.navigation.ShoppingRoute


data class BottomNavItem(
    val icon : ImageVector,
    val selectedIcon : ImageVector,
    val label : String,
    val route : MainRoute
)



@Composable
fun BottomNavigation(
    navController: NavHostController,
    modifier : Modifier,
){
    val listOfItem = mutableListOf(
            BottomNavItem(
            icon = Icons.Outlined.Home,
            selectedIcon = Icons.Default.Home,
            label = "Home",
            route = HomeRoute
        ),
            BottomNavItem(
            icon = Icons.Outlined.ShoppingCart,
            selectedIcon = Icons.Default.ShoppingCart,
            label = "Shopping",
            route = ShoppingRoute

        ),
            BottomNavItem(
            icon = Icons.Outlined.Notifications,
            selectedIcon = Icons.Default.Notifications,
            label = "Notification",
            route = NotificationsRoute
        ),
            BottomNavItem(
            icon = Icons.Outlined.AccountCircle,
            selectedIcon = Icons.Default.AccountCircle,
            label = "Profile",
            route = ProfileRoute
        )
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(modifier) {

        listOfItem.forEach { item ->

            val selected = currentRoute == item.route::class.qualifiedName
            NavigationBarItem(
                label = {
                    Text(text = item.label)
                },
                alwaysShowLabel = false,
                selected = selected,
                onClick = {
                    if (currentRoute !=  item.route::class.qualifiedName) {
                        navController.navigate(item.route) {
                            // Avoid multiple copies
                            launchSingleTop = true

                            restoreState = true
                            // Save state of other tabs
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                        }
                    }
                },
                icon = {
                    Image(
                        imageVector = if (selected) item.selectedIcon else item.icon,
                        contentDescription = item.label
                    )
                }
            )
        }
    }
}
