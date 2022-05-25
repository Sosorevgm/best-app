package com.sosorevgm.best_app.main

class MainRepository(
    private val api: MainApi
) {
    fun getPriceAsync() = api.getPriceAsync()
}
