package com.sosorevgm.best_app.main

import com.sosorevgm.best_app.models.Price
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

private const val PRICE_PATH = "v1/bpi/currentprice.json"

interface MainApi {

    @GET(PRICE_PATH)
    fun getPriceAsync(): Deferred<Price>
}
