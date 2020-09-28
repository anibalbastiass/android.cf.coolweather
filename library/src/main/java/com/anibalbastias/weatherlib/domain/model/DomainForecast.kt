package com.anibalbastias.weatherlib.domain.model

data class DomainForecast(
    val title: String,
    val forecasts: List<DomainForecastItem>
)