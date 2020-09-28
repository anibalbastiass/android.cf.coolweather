package com.anibalbastias.weatherlib.factory

import com.anibalbastias.weatherlib.data.model.currentconditions.RemoteCurrentCondition
import com.anibalbastias.weatherlib.domain.model.DomainCurrentCondition
import com.anibalbastias.testutils.foundation.RandomFactory.generateDouble
import com.anibalbastias.testutils.foundation.RandomFactory.generateInt
import com.anibalbastias.testutils.foundation.RandomFactory.generateRandomDate
import com.anibalbastias.testutils.foundation.RandomFactory.generateString
import com.anibalbastias.weatherlib.data.model.common.RemoteMetricType
import com.anibalbastias.weatherlib.data.model.common.RemoteUnit
import com.anibalbastias.weatherlib.data.model.currentconditions.RemoteDirection
import com.anibalbastias.weatherlib.data.model.currentconditions.RemotePrecipitationSummary
import com.anibalbastias.weatherlib.data.model.currentconditions.RemoteWind
import com.anibalbastias.weatherlib.factory.CommonFactory.makeRemoteMetric

object CurrentConditionFactory {

    private const val MIN_YEAR = 1900
    private const val MAX_YEAR = 2020

    // Generate only needed data for Mappers
    fun makeRemoteCurrentCondition() = RemoteCurrentCondition(
        localObservationDateTime = generateString(),
        weatherText = generateString(),
        weatherIcon = generateInt(),
        relativeHumidity = generateInt(),
        temperature = makeRemoteMetric(),
        realFeelTemperature = makeRemoteMetric(),
        wind = makeRemoteWind(),
        pressure = makeRemoteMetric(),
        precipitationSummary = makeRemotePrecipitationSummary()
    )

    private fun makeRemotePrecipitationSummary() = RemotePrecipitationSummary(
        precipitation = makeRemoteMetric(),
        pastHour = makeRemoteMetric(),
        past3Hours = makeRemoteMetric(),
        past6Hours = makeRemoteMetric(),
        past9Hours = makeRemoteMetric(),
        past12Hours = makeRemoteMetric(),
        past18Hours = makeRemoteMetric(),
        past24Hours = makeRemoteMetric()
    )

    private fun makeRemoteWind() = RemoteWind(
        direction = makeRemoteDirection(),
        speed = makeRemoteMetric()
    )

    private fun makeRemoteDirection() = RemoteDirection(
        degrees = generateInt(),
        localized = generateString(),
        english = generateString()
    )

    fun makeDomainCurrentCondition() = DomainCurrentCondition(
        currentDate = generateRandomDate(MIN_YEAR, MAX_YEAR).toString(),
        weatherText = generateString(),
        weatherIcon = generateString(),
        currentTemperature = generateString(),
        realFeelTemperature = generateString(),
        relativeHumidity = generateString(),
        directionWind = generateString(),
        speedWind = generateString(),
        pressure = generateString(),
        precipitationSummary = generateString()
    )
}