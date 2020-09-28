package com.anibalbastias.weatherlib.presentation.mapper

import com.anibalbastias.weatherlib.domain.model.DomainGeoLocation
import com.anibalbastias.weatherlib.presentation.model.WeatherGeoLocation

class WeatherGeoLocationMapper {

    fun DomainGeoLocation.fromDomainToUi() = WeatherGeoLocation(
        cityKey = cityKey,
        cityName = cityName,
        country = country,
        areaName = areaName,
        parentCity = parentCity
    )

}