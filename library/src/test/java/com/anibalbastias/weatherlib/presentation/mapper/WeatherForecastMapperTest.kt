package com.anibalbastias.weatherlib.presentation.mapper

import com.anibalbastias.weatherlib.domain.model.DomainForecastItem
import com.anibalbastias.weatherlib.factory.ForecastFactory
import com.anibalbastias.weatherlib.presentation.model.WeatherForecastItem
import junit.framework.Assert.assertEquals
import org.junit.Test

class WeatherForecastMapperTest {

    private val mapper = WeatherForecastMapper()

    @Test
    fun `given DomainForecast, when fromDomainToUi, then WeatherForecast`() {
        val domain = ForecastFactory.makeDomainForecast()

        val ui = with(mapper) { domain.fromDomainToUi() }

        assertEquals("title", domain.title, ui.title)
        assertForecastItem(domain.forecasts, ui.forecasts)
    }

    private fun assertForecastItem(
        domain: List<DomainForecastItem>,
        ui: List<WeatherForecastItem>
    ) {
        domain.zip(ui).map {
            val domainItem = it.first
            val uiItem = it.second

            assertEquals("date", domainItem.date, uiItem.date)
            assertEquals("min", domainItem.min, uiItem.min)
            assertEquals("max", domainItem.max, uiItem.max)
            assertEquals("dayIcon", domainItem.dayIcon, uiItem.dayIcon)
            assertEquals("nightIcon", domainItem.nightIcon, uiItem.nightIcon)
        }
    }
}