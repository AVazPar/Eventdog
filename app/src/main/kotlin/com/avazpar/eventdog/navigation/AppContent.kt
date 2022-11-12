package com.avazpar.eventdog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.avazpar.designsystem.foundations.EventdogTheme
import com.avazpar.eventdog.details.presentation.DetailsScreen
import com.avazpar.eventdog.home.presentation.HomeScreen

@Composable
fun AppContent() {
    EventdogTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route
        ) {
            composable(route = Screens.Home.route) {
                HomeScreen(
                    navigateToDetails = {
                        navController.navigate(Screens.Details.route)
                    }
                )
            }
            composable(route = Screens.Details.route) {
                DetailsScreen(
                    navigateToHome = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}