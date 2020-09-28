package com.anibalbastias.weatherlib.presentation.mapper

import com.anibalbastias.weatherlib.domain.model.DomainForecast
import com.anibalbastias.weatherlib.domain.model.DomainForecastItem
import com.anibalbastias.weatherlib.presentation.model.WeatherForecast
import com.anibalbastias.weatherlib.presentation.model.WeatherForecastItem

class WeatherForecastMapper {

    fun DomainForecast.fromDomainToUi() = WeatherForecast(
        title = title,
        forecasts = forecasts.map { it.fromDomainToUi() }
    )

    private fun DomainForecastItem.fromDomainToUi() = WeatherForecastItem(
        date = date,
        min = min,
        max = max,
        dayIcon = dayIcon,
        nightIcon = nightIcon
    )
}