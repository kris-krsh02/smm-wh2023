package com.example.sharemymeals.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sharemymeals.HomeScreen
import com.example.sharemymeals.LoginScreen
import com.example.sharemymeals.PointsScreen
import com.example.sharemymeals.SwipeScreen

@Composable
fun NavGraph (navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Login.route)
    {
        composable(route = Screens.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screens.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screens.Swipes.route) {
            SwipeScreen()
        }
        composable(route = Screens.Points.route) {
            PointsScreen()
        }
    }

}