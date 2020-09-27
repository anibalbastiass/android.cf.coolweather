package com.anibalbastias.weatherlib.data.repository

import com.anibalbastias.weatherlib.data.mapper.CurrentConditionsMapper
import com.anibalbastias.weatherlib.data.mapper.ForecastMapper
import com.anibalbastias.weatherlib.data.mapper.GeoPositionMapper
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Request.FIVE_DAYS
import com.anibalbastias.weatherlib.data.retrofit.service.Constants.Request.ONE_DAY
import com.anibalbastias.weatherlib.data.retrofit.service.WeatherService
import com.anibalbastias.weatherlib.domain.model.DomainCurrentCondition
import com.anibalbastias.weatherlib.domain.model.DomainForecast
import com.anibalbastias.weatherlib.domain.model.DomainGeoLocation
import com.anibalbastias.weatherlib.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val service: WeatherService,
    private val geoPositionMapper: GeoPositionMapper,
    private val currentConditionsMapper: CurrentConditionsMapper,
    private val forecastMapper: ForecastMapper
) : WeatherRepository {

    override suspend fun getGeoPosition(query: String): DomainGeoLocation? =
        with(geoPositionMapper) {
            service.getGeoPosition(query)?.fromRemoteToDomain()
        }

    override suspend fun getCurrentConditions(cityKey: String): DomainCurrentCondition? =
        with(currentConditionsMapper) {
            service.getCurrentConditions(cityKey, true)?.first()?.fromRemoteToDomain()
        }

    override suspend fun get1DayDailyForecasts(cityKey: String): DomainForecast? =
        with(forecastMapper) {
            service.getNDayDailyForecasts(ONE_DAY, cityKey, false)?.fromRemoteToDomain()
        }

    override suspend fun get5DayDailyForecasts(cityKey: String): DomainForecast? =
        with(forecastMapper) {
            service.getNDayDailyForecasts(FIVE_DAYS, cityKey, false)?.fromRemoteToDomain()
        }
}
