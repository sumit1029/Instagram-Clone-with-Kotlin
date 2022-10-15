package com.example.instacloneapp

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object ChatScreen: Screen(route = "chat_screen")
}
