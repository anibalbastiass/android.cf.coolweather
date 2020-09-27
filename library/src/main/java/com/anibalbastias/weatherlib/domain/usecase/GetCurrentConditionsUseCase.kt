package com.anibalbastias.weatherlib.domain.usecase

import com.anibalbastias.weatherlib.domain.model.DomainCurrentCondition
import com.anibalbastias.weatherlib.domain.repository.WeatherRepository

class GetCurrentConditionsUseCase(private val repository: WeatherRepository) {
    suspend fun execute(cityKey: String): DomainCurrentCondition? =
        repository.getCurrentConditions(cityKey)
}
