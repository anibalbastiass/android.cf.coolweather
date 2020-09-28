package com.anibalbastias.weatherlib.presentation.mapper

import com.anibalbastias.weatherlib.factory.GeoLocationFactory
import junit.framework.Assert.assertEquals
import org.junit.Test

class WeatherGeoLocationMapperTest {

    private val mapper = WeatherGeoLocationMapper()

    @Test
    fun `given DomainGeoLocation, when fromDomainToUi, then WeatherGeoLocation`() {
        val domain = GeoLocationFactory.makeDomainGeoLocation()

        val ui = with(mapper) { domain.fromDomainToUi() }

        assertEquals("cityKey", domain.cityKey, ui.cityKey)
        assertEquals("cityName", domain.cityName, ui.cityName)
        assertEquals("country", domain.country, ui.country)
        assertEquals("areaName", domain.areaName, ui.areaName)
        assertEquals("parentCity", domain.parentCity, ui.parentCity)
    }
}