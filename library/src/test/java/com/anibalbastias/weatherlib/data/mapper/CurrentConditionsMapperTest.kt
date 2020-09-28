package com.anibalbastias.weatherlib.data.mapper

import com.anibalbastias.weatherlib.data.extension.DataExtension
import com.anibalbastias.weatherlib.factory.CurrentConditionFactory
import junit.framework.Assert.assertEquals
import org.junit.Test

class CurrentConditionsMapperTest {

    private val mapper = CurrentConditionsMapper()

    @Test
    fun `given RemoteCurrentCondition, when fromRemoteToDomain, then DomainCurrentCondition`() {
        val remote = CurrentConditionFactory.makeRemoteCurrentCondition()

        val domain = with(mapper) { remote.fromRemoteToDomain() }

        assert(remote.localObservationDateTime != null)

        with(DataExtension) {
            assertEquals("currentDate", remote.localObservationDateTime, domain.currentDate)
            assertEquals("weatherText", remote.weatherText, domain.weatherText)
            assertEquals("weatherIcon", getUrlIcon(remote.weatherIcon ?: 0), domain.weatherIcon)
            assertEquals(
                "currentTemperature",
                remote.temperature?.imperial?.getImperialFormat(),
                domain.currentTemperature
            )
            assertEquals(
                "realFeelTemperature",
                remote.realFeelTemperature?.imperial?.getImperialFormat(),
                domain.realFeelTemperature
            )
            assertEquals(
                "relativeHumidity",
                "${remote.relativeHumidity}%",
                domain.relativeHumidity
            )
            assertEquals(
                "directionWind",
                remote.wind?.direction?.run { "$degrees $english" }?.toString(),
                domain.directionWind
            )
            assertEquals(
                "speedWind",
                remote.wind?.speed?.imperial?.getImperialFormat(),
                domain.speedWind
            )
            assertEquals(
                "pressure",
                remote.pressure?.imperial?.getImperialFormat(),
                domain.pressure
            )
            assertEquals(
                "precipitationSummary",
                remote.precipitationSummary?.precipitation?.imperial?.getImperialFormat() ?: "",
                domain.precipitationSummary
            )
        }
    }
}