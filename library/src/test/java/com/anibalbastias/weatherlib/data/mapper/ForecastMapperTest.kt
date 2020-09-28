package com.anibalbastias.weatherlib.data.mapper

import com.anibalbastias.weatherlib.data.extension.DataExtension
import com.anibalbastias.weatherlib.data.model.forecast.RemoteDailyForecastsItem
import com.anibalbastias.weatherlib.domain.model.DomainForecastItem
import com.anibalbastias.weatherlib.factory.ForecastFactory
import junit.framework.Assert.*
import org.junit.Test

class ForecastMapperTest {

    private val mapper = ForecastMapper()

    @Test
    fun `given RemoteForecast, when fromRemoteToDomain, then DomainForecast`() {
        val remote = ForecastFactory.makeRemoteForecast()

        val domain = with(mapper) { remote.fromRemoteToDomain() }

        assert(remote.headline != null)
        assertEquals("title", remote.headline?.text, domain.title)
        assert(remote.dailyForecasts?.isEmpty() == false)
        assertForecastItem(remote.dailyForecasts, domain.forecasts)
    }

    private fun assertForecastItem(
        remote: List<RemoteDailyForecastsItem?>?,
        domain: List<DomainForecastItem>
    ) {
        remote?.zip(domain)?.map {
            val remoteItem = it.first
            val domainItem = it.second

            with(DataExtension) {
                assertEquals("date", remoteItem?.date?.formatDate(), domainItem.date)
                assertEquals(
                    "min",
                    remoteItem?.temperature?.minimum?.imperial?.getImperialFormat(),
                    domainItem.min
                )
                assertEquals(
                    "max",
                    remoteItem?.temperature?.maximum?.imperial?.getImperialFormat(),
                    domainItem.max
                )
                assertEquals(
                    "dayIcon",
                    getUrlIcon(remoteItem?.day?.icon ?: 0), domainItem.dayIcon
                )
                assertEquals(
                    "nightIcon",
                    getUrlIcon(remoteItem?.night?.icon ?: 0),
                    domainItem.nightIcon
                )
            }
        }
    }
}