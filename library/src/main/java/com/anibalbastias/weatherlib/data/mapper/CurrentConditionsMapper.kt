package com.anibalbastias.weatherlib.data.mapper

import com.anibalbastias.weatherlib.data.extension.DataExtension
import com.anibalbastias.weatherlib.data.model.currentconditions.RemoteCurrentCondition
import com.anibalbastias.weatherlib.domain.model.DomainCurrentCondition

class CurrentConditionsMapper {

    fun RemoteCurrentCondition.fromRemoteToDomain() = with(DataExtension) {
        DomainCurrentCondition(
            currentDate = localObservationDateTime ?: "",
            weatherText = weatherText ?: "",
            weatherIcon = getUrlIcon(weatherIcon ?: 0),
            currentTemperature = temperature?.imperial?.getImperialFormat() ?: "",
            realFeelTemperature = realFeelTemperature?.imperial?.getImperialFormat() ?: "",
            relativeHumidity = "$relativeHumidity%",
            directionWind = wind?.direction?.apply { "$degrees $english" }?.toString() ?: "",
            speedWind = wind?.speed?.imperial?.getImperialFormat() ?: "",
            pressure = pressure?.imperial?.getImperialFormat() ?: "",
            precipitationSummary = precipitationSummary?.precipitation?.imperial?.getImperialFormat()
                ?: ""
        )
    }
}