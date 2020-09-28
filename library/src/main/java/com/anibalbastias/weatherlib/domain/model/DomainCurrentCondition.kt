package com.anibalbastias.weatherlib.domain.model

data class DomainCurrentCondition(
    val currentDate: String,
    val weatherText: String,
    val weatherIcon: String,
    val currentTemperature: String,
    val realFeelTemperature: String,
    val relativeHumidity: String,
    val directionWind: String,
    val speedWind: String,
    val pressure: String,
    val precipitationSummary: String
)