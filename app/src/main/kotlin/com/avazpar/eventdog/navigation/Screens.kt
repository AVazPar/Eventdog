package com.avazpar.eventdog.navigation

sealed class Screens(val route: String) {
    object Home : Screens("home")
    object Details : Screens("details/{eventId}")

    fun withArgs(vararg args: String):String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}