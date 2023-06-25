package com.example.sharemymeals.navigation

sealed class Screens (val route: String){
    object Login: Screens("login_screen")
    object Home: Screens("home_screen")
    object Points: Screens("points_screen")
    object Swipes: Screens("swipes_screen")
}