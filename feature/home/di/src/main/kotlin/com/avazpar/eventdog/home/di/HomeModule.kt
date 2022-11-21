package com.avazpar.eventdog.home.di

import com.avazpar.eventdog.home.data.di.eventsDataBase
import com.avazpar.eventdog.home.data.di.homeDataModule
import com.avazpar.eventdog.home.domain.di.homeDomainModule
import com.avazpar.eventdog.home.presentation.di.homePresentationModule

val homeModule = homePresentationModule + homeDomainModule + homeDataModule
val dataBase = eventsDataBase