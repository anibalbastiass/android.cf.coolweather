package com.anibalbastias.weatherlib.data.mapper

import com.anibalbastias.weatherlib.data.model.location.RemoteGeoLocation
import com.anibalbastias.weatherlib.domain.model.DomainGeoLocation

class GeoPositionMapper {

    fun RemoteGeoLocation.fromRemoteToDomain() = DomainGeoLocation(
        cityKey = key ?: "",
        cityName = englishName ?: "",
        country = country?.englishName ?: "",
        areaName = administrativeArea?.englishName ?: "",
        parentCity = parentCity?.englishName ?: ""
    )
}
