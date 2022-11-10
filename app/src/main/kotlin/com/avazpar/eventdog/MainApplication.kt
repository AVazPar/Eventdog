package com.avazpar.eventdog

import android.app.Application
import com.avazpar.eventdog.details.di.detailsModule
import com.avazpar.eventdog.di.mainModule
import com.avazpar.eventdog.home.di.homeModule
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(modules = mainModule + homeModule + detailsModule)
        }
    }
}