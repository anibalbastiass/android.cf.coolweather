package com.anibalbastias.weatherlib.factory

import com.anibalbastias.testutils.foundation.RandomFactory
import com.anibalbastias.testutils.foundation.RandomFactory.generateString
import com.anibalbastias.weatherlib.data.extension.DataExtension
import com.anibalbastias.weatherlib.data.model.common.RemoteForecastDay
import com.anibalbastias.weatherlib.data.model.common.RemoteMaxMin
import com.anibalbastias.weatherlib.data.model.forecast.RemoteDailyForecastsItem
import com.anibalbastias.weatherlib.data.model.forecast.RemoteForecast
import com.anibalbastias.weatherlib.data.model.forecast.RemoteForecastHeadline
import com.anibalbastias.weatherlib.domain.model.DomainForecast
import com.anibalbastias.weatherlib.domain.model.DomainForecastItem
import com.anibalbastias.weatherlib.factory.CommonFactory.makeRemoteMetric

object ForecastFactory {

    // Generate only needed data for Mappers
    fun makeRemoteForecast() = RemoteForecast(
        headline = makeRemoteForecastHeadline(),
        dailyForecasts = (0..5).map { makeRemoteForecastItem() }
    )

    private fun makeRemoteForecastItem() = with(DataExtension) {
        RemoteDailyForecastsItem(
            date = generateString(),
            temperature = makeRemoteMaxMin(),
            day = makeRemoteForecastDay(),
            night = makeRemoteForecastDay()
        )
    }

    private fun makeRemoteForecastDay() = RemoteForecastDay(
        icon = RandomFactory.generateInt()
    )

    private fun makeRemoteMaxMin() = RemoteMaxMin(
        minimum = makeRemoteMetric(),
        maximum = makeRemoteMetric()
    )

    private fun makeRemoteForecastHeadline() = RemoteForecastHeadline(
        text = generateString()
    )

    fun makeDomainForecast() = DomainForecast(
        title = generateString(),
        forecasts = (0..5).map { makeDomainForecastItem() }
    )

    private fun makeDomainForecastItem() = DomainForecastItem(
        date = generateString(),
        min = generateString(),
        max = generateString(),
        dayIcon = generateString(),
        nightIcon = generateString()
    )

}