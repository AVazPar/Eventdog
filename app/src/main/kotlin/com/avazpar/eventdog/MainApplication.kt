package com.avazpar.eventdog

import android.app.Application
import com.avazpar.eventdog.details.di.profileModule
import com.avazpar.eventdog.di.mainModule
import com.avazpar.eventdog.home.di.dataSourceModule
import com.avazpar.eventdog.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(modules = mainModule + homeModule + profileModule + dataSourceModule)
        }
    }
}