package com.sosorevgm.best_app.di

import com.sosorevgm.best_app.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel {
        MainViewModel(repository = get())
    }
}
