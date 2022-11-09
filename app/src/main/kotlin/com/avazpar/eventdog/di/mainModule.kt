package com.avazpar.eventdog.di

import com.avazpar.eventdog.home.presentation.HomeFeatureImpl
import com.avazpar.eventdog.navigation.HomeFeatureApi
import org.koin.dsl.module

val mainModule = module{
    single<HomeFeatureApi> { HomeFeatureImpl() }
}