package com.avazpar.eventdog.details.di

import com.avazpar.eventdog.details.presentation.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailsModule = module {
    viewModel { DetailsViewModel() }
}