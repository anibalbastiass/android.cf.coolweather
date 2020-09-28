package com.anibalbastias.weatherlib.domain.repository

import com.anibalbastias.weatherlib.domain.model.DomainCurrentCondition
import com.anibalbastias.weatherlib.domain.model.DomainForecast
import com.anibalbastias.weatherlib.domain.model.DomainGeoLocation

interface WeatherRepository {

    suspend fun getGeoPosition(query: String): DomainGeoLocation?

    suspend fun getCurrentConditions(cityKey: String): DomainCurrentCondition?

    suspend fun get1DayDailyForecasts(cityKey: String): DomainForecast?

    suspend fun get5DayDailyForecasts(cityKey: String): DomainForecast?

}
