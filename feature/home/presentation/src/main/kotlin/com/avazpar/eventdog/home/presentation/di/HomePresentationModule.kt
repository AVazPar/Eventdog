package com.avazpar.eventdog.home.presentation.di

import com.avazpar.eventdog.home.presentation.details.DetailsViewModel
import com.avazpar.eventdog.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homePresentationModule = module {
    viewModel { HomeViewModel(getAllDogEvents = get()) }
    viewModel { DetailsViewModel(getDogEventDetails = get()) }
}