package com.avazpar.eventdog.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface FeatureApi {
    fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier = Modifier
    )
}
interface HomeFeatureApi : FeatureApi {
    fun route(): String
}