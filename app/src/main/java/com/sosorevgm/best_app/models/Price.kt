package com.sosorevgm.best_app.models

import com.google.gson.annotations.SerializedName

data class Price(
    val time: Time,
    val disclaimer: String,
    val chartName: String,
    val bpi: Bpi
)

data class Bpi(
    @SerializedName("USD")
    val usd: Eur,

    @SerializedName("GBP")
    val gbp: Eur,

    @SerializedName("EUR")
    val eur: Eur
)

data class Eur(
    val code: String,
    val symbol: String,
    val rate: String,
    val description: String,

    @SerializedName("rate_float")
    val rateFloat: Double
)

data class Time(
    val updated: String,
    val updatedISO: String,
    val updateduk: String
)
