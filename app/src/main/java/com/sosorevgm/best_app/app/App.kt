package com.sosorevgm.best_app.app

import android.app.Application
import com.sosorevgm.best_app.di.repositories
import com.sosorevgm.best_app.di.retrofit
import com.sosorevgm.best_app.di.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(viewModels, repositories, retrofit)
        }
    }
}
