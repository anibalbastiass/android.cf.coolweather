package com.anibalbastias.weatherlib.presentation.mapper

import com.anibalbastias.weatherlib.domain.model.DomainCurrentCondition
import com.anibalbastias.weatherlib.presentation.model.WeatherCurrentCondition

class WeatherCurrentConditionMapper {

    fun DomainCurrentCondition.fromDomainToUi() = WeatherCurrentCondition(
        currentDate = currentDate,
        weatherText = weatherText,
        weatherIcon = weatherIcon,
        currentTemperature = currentTemperature,
        realFeelTemperature = realFeelTemperature,
        relativeHumidity = relativeHumidity,
        directionWind = directionWind,
        speedWind = speedWind,
        pressure = pressure,
        precipitationSummary = precipitationSummary
    )

}