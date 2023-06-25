package com.example.sharemymeals.navigation


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
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
            SwipeScreen(navController = navController)
        }
        composable(route = Screens.Points.route) {
            PointsScreen(navController = navController)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageAppBar(titleText: String, navController: NavController) {
        TopAppBar(
            title = { Text(text = titleText )},
            navigationIcon = {
                IconButton(onClick = {navController.navigate(Screens.Home.route)}) {
                    Icon(Icons.Filled.ArrowBack, "backIcon")
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = Color.White,
            )
        )
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(titleText: String, navController: NavController) {
    TopAppBar(
        title = { Text(text = titleText )},
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White,
        ),

        actions = {
            IconButton(onClick = { navController.navigate(Screens.Login.route) }) {
                Icon(Icons.Default.ExitToApp, contentDescription = "Logout", tint = Color.White)
            }
        }
    )
}
