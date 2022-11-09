package com.avazpar.eventdog.navigation

import com.avazpar.eventdog.home.presentation.HomeFeatureImpl

object DependencyProvider {

    private lateinit var homeFeatureApi: HomeFeatureApi

    fun provideImpl(
        homeFeatureApi: HomeFeatureImpl,
    ) {
        this.homeFeatureApi = homeFeatureApi
    }

    fun homeFeature(): HomeFeatureApi = homeFeatureApi
}
