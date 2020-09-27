package com.anibalbastias.weatherlib.domain.usecase

import com.anibalbastias.weatherlib.domain.model.DomainGeoLocation
import com.anibalbastias.weatherlib.domain.repository.WeatherRepository

class GetGeoPositionUseCase(private val repository: WeatherRepository) {
    suspend fun execute(query: String): DomainGeoLocation? = repository.getGeoPosition(query)
}
