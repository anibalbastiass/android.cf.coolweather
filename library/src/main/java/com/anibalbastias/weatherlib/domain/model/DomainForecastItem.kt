package com.anibalbastias.weatherlib.domain.model

data class DomainForecastItem(
    val date: String,
    val min: String,
    val max: String,
    val dayIcon: String,
    val nightIcon: String
)