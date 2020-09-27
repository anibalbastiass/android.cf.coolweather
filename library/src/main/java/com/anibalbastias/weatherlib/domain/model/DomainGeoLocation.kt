package com.anibalbastias.weatherlib.domain.model

data class DomainGeoLocation(
    val cityKey: String,
    val cityName: String,
    val country: String,
    val areaName: String,
    val parentCity: String
)