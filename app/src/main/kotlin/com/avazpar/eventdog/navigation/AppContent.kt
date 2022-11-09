package com.avazpar.eventdog

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.avazpar.designsystem.foundations.EventdogTheme
import com.avazpar.eventdog.navigation.DependencyProvider

@Composable
fun AppContent() {
    EventdogTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = DependencyProvider.homeFeature().route()
        ) {
            DependencyProvider.homeFeature().registerGraph(
                navGraphBuilder = this,
                navController = navController
            )
        }
    }
}