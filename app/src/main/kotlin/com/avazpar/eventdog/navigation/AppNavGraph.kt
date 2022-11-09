package com.avazpar.eventdog.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = DependencyProvider.homeFeature().route()
    ) {
        register(
            DependencyProvider.homeFeature(),
            navController = navController,
            modifier = modifier
        )
    }
}