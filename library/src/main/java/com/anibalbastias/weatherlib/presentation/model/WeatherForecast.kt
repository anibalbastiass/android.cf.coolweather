package com.anibalbastias.weatherlib.presentation.model

data class WeatherForecast(
    val title: String,
    val forecasts: List<WeatherForecastItem>
)