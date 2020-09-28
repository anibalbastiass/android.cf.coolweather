package com.anibalbastias.weatherlib.factory

import com.anibalbastias.testutils.foundation.RandomFactory
import com.anibalbastias.weatherlib.data.model.common.RemoteMetricType
import com.anibalbastias.weatherlib.data.model.common.RemoteUnit

object CommonFactory {

    fun makeRemoteMetric() = RemoteMetricType(
        metric = makeRemoteUnit(),
        imperial = makeRemoteUnit()
    )

    fun makeRemoteUnit() = RemoteUnit(
        unitType = RandomFactory.generateInt(),
        value = RandomFactory.generateDouble(),
        unit = RandomFactory.generateString()
    )
}