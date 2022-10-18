package com.example.instacloneapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route) {
            HomePage(navController = navController)
        }
        composable(route = Screen.ChatScreen.route) {
            ChatPage(navController = navController)
        }
        composable(route = Screen.ProfileScreen.route + "/{id}", arguments = listOf(navArgument("id"){
            type = NavType.IntType
            defaultValue = 0
            nullable = false
        })) {entry ->
            ProfilePage(navController = navController, id = entry.arguments!!.getInt("id"))
        }
        composable(route = Screen.ActivityScreen.route){
            NotificationPage(navController = navController)
        }
    }
}