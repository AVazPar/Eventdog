package com.avazpar.eventdog.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface FeatureApi {
    fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    )
}
interface HomeFeatureApi : FeatureApi {
    fun route(): String
}
interface DetailsFeatureApi: FeatureApi {
    fun route(): String
}