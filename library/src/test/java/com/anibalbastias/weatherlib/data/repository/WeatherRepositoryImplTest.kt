package com.anibalbastias.weatherlib.data.repository

import com.anibalbastias.testutils.foundation.RandomFactory
import com.anibalbastias.weatherlib.data.mapper.CurrentConditionsMapper
import com.anibalbastias.weatherlib.data.mapper.ForecastMapper
import com.anibalbastias.weatherlib.data.mapper.GeoPositionMapper
import com.anibalbastias.weatherlib.data.retrofit.service.WeatherService
import com.anibalbastias.weatherlib.factory.CurrentConditionFactory
import com.anibalbastias.weatherlib.factory.ForecastFactory
import com.anibalbastias.weatherlib.factory.GeoLocationFactory
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test

class WeatherRepositoryImplTest {

    @MockK
    internal lateinit var mockService: WeatherService
    private lateinit var geoPositionMapper: GeoPositionMapper
    private lateinit var currentConditionsMapper: CurrentConditionsMapper
    private lateinit var forecastMapper: ForecastMapper
    private lateinit var cut: WeatherRepositoryImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        geoPositionMapper = GeoPositionMapper()
        currentConditionsMapper = CurrentConditionsMapper()
        forecastMapper = ForecastMapper()
        cut = WeatherRepositoryImpl(
            mockService, geoPositionMapper, currentConditionsMapper, forecastMapper
        )
    }

    @Test
    fun `getGeoPosition fetches DomainGeoLocation and maps to RemoteGeoLocation`() {
        // given
        val latitude = RandomFactory.generateDouble()
        val longitude = RandomFactory.generateDouble()
        val query = "$latitude,$longitude"

        coEvery {
            cut.getGeoPosition(query)
        } returns with(geoPositionMapper) {
            GeoLocationFactory.makeRemoteGeoLocation().fromRemoteToDomain()
        }
    }

    @Test
    fun `getCurrentConditions fetches DomainCurrentCondition and maps to RemoteCurrentCondition`() {
        // given
        val cityKey = "${RandomFactory.generateInt()}"

        coEvery {
            cut.getCurrentConditions(cityKey)
        } returns with(currentConditionsMapper) {
            CurrentConditionFactory.makeRemoteCurrentCondition().fromRemoteToDomain()
        }
    }

    @Test
    fun `get1DayDailyForecasts fetches DomainCurrentCondition and maps to RemoteCurrentCondition`() {
        // given
        val cityKey = "${RandomFactory.generateInt()}"

        coEvery {
            cut.get1DayDailyForecasts(cityKey)
        } returns with(forecastMapper) {
            ForecastFactory.makeRemoteForecast().fromRemoteToDomain()
        }
    }

    @Test
    fun `get5DayDailyForecasts fetches DomainCurrentCondition and maps to RemoteCurrentCondition`() {
        // given
        val cityKey = "${RandomFactory.generateInt()}"

        coEvery {
            cut.get5DayDailyForecasts(cityKey)
        } returns with(forecastMapper) {
            ForecastFactory.makeRemoteForecast().fromRemoteToDomain()
        }
    }
}
