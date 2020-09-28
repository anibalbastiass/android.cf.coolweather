package com.anibalbastias.weatherlib.presentation.model

data class WeatherGeoLocation(
    val cityKey: String,
    val cityName: String,
    val country: String,
    val areaName: String,
    val parentCity: String
)