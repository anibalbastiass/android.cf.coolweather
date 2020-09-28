package com.anibalbastias.weatherlib.presentation.mapper

import com.anibalbastias.weatherlib.factory.CurrentConditionFactory
import junit.framework.Assert.assertEquals
import org.junit.Test

class WeatherCurrentConditionMapperTest {

    private val mapper = WeatherCurrentConditionMapper()

    @Test
    fun `given DomainCurrentCondition, when fromDomainToUi, then WeatherCurrentCondition`() {
        val domain = CurrentConditionFactory.makeDomainCurrentCondition()

        val ui = with(mapper) { domain.fromDomainToUi() }

        assertEquals("currentDate", domain.currentDate, ui.currentDate)
        assertEquals("weatherText", domain.weatherText, ui.weatherText)
        assertEquals("weatherIcon", domain.weatherIcon, ui.weatherIcon)
        assertEquals("currentTemperature", domain.currentTemperature, ui.currentTemperature)
        assertEquals("realFeelTemperature", domain.realFeelTemperature, ui.realFeelTemperature)
        assertEquals("relativeHumidity", domain.relativeHumidity, ui.relativeHumidity)
        assertEquals("directionWind", domain.directionWind, ui.directionWind)
        assertEquals("speedWind", domain.speedWind, ui.speedWind)
        assertEquals("pressure", domain.pressure, ui.pressure)
        assertEquals("precipitationSummary", domain.precipitationSummary, ui.precipitationSummary)
    }
}