package com.sosorevgm.best_app.di

import com.sosorevgm.best_app.main.MainRepository
import org.koin.dsl.module

val repositories = module {
    single {
        MainRepository(api = get())
    }
}
