package com.anibalbastias.weatherlib.factory

import com.anibalbastias.testutils.foundation.RandomFactory.generateString
import com.anibalbastias.weatherlib.data.model.common.RemoteLocal
import com.anibalbastias.weatherlib.data.model.location.RemoteAdministrativeArea
import com.anibalbastias.weatherlib.data.model.location.RemoteGeoLocation
import com.anibalbastias.weatherlib.domain.model.DomainGeoLocation

object GeoLocationFactory {

    fun makeRemoteGeoLocation() = RemoteGeoLocation(
        key = generateString(),
        englishName = generateString(),
        country = makeRemoteLocal(),
        administrativeArea = makeRemoteAdministrativeArea(),
        parentCity = makeRemoteLocal()
    )

    private fun makeRemoteAdministrativeArea() = RemoteAdministrativeArea(
        englishType = generateString()
    )

    private fun makeRemoteLocal() = RemoteLocal(
        englishName = generateString()
    )

    fun makeDomainGeoLocation() = DomainGeoLocation(
        cityKey = generateString(),
        cityName = generateString(),
        country = generateString(),
        areaName = generateString(),
        parentCity = generateString()
    )
}