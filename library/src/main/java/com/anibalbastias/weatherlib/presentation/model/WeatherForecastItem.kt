package com.anibalbastias.weatherlib.presentation.model

data class WeatherForecastItem(
    val date: String,
    val min: String,
    val max: String,
    val dayIcon: String,
    val nightIcon: String
)