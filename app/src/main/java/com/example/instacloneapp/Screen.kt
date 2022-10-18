package com.example.instacloneapp

import androidx.compose.ui.input.key.Key.Companion.J

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object ChatScreen: Screen(route = "chat_screen")
    object ProfileScreen: Screen("profile_screen")
    object ActivityScreen: Screen("activity_screen")

    fun withArgs(vararg args: Int): String{
        return buildString {
            append(route)
            args.forEach { arg->
                append("/$arg")
            }
        }
    }
}
