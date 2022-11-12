package com.avazpar.eventdog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.avazpar.designsystem.foundations.EventdogTheme
import com.avazpar.eventdog.home.presentation.HomeScreen
import com.avazpar.eventdog.home.presentation.details.DetailsScreen

@Composable
fun EventDogNavHost() {
    EventdogTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route
        ) {
            composable(route = Screens.Home.route) {
                HomeScreen(
                    navigateToDetails = { eventId ->
                        navController.navigate("details/$eventId")
                    }
                )
            }
            composable(
                route = Screens.Details.route,
                arguments = listOf(
                    navArgument("eventId"){
                        type = NavType.StringType
                    }
                )
            ) {
                DetailsScreen(
                    eventId = it.arguments?.getString("eventId")!!,
                    navigateToHome = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}