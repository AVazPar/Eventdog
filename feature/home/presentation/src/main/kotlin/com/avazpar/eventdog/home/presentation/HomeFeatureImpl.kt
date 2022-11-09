package com.avazpar.eventdog.home.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.avazpar.eventdog.navigation.HomeFeatureApi

class HomeFeatureImpl : HomeFeatureApi {

    private val route = "home"
    override fun route() = route

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController
    ) {
        navGraphBuilder.composable(route) {
            HomeScreen(handleNavigation = ::handleNavigation)
        }
    }

    private fun handleNavigation(navigation: HomeNavigation) {
        when (navigation) {
            HomeNavigation.ToDetails -> Unit//findNavController().navigate(HomeFragmentDirections.actionToDetails())
        }
    }
}