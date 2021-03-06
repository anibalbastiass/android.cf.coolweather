package com.anibalbastias.weatherlib.domain.usecase

import com.anibalbastias.weatherlib.domain.model.DomainForecast
import com.anibalbastias.weatherlib.domain.repository.WeatherRepository

class Get5DayDailyForecastsUseCase(private val repository: WeatherRepository) {
    suspend fun execute(cityKey: String): DomainForecast? =
        repository.get5DayDailyForecasts(cityKey)
}
