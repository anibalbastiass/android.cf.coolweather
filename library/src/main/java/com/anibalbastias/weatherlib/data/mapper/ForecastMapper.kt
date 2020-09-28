package com.anibalbastias.weatherlib.data.mapper

import com.anibalbastias.weatherlib.data.extension.DataExtension
import com.anibalbastias.weatherlib.data.model.forecast.RemoteDailyForecastsItem
import com.anibalbastias.weatherlib.data.model.forecast.RemoteForecast
import com.anibalbastias.weatherlib.domain.model.DomainForecast
import com.anibalbastias.weatherlib.domain.model.DomainForecastItem

class ForecastMapper {

    fun RemoteForecast.fromRemoteToDomain() = DomainForecast(
        title = headline?.text ?: "",
        forecasts = dailyForecasts?.map { it?.fromRemoteToDomain() }
                as List<DomainForecastItem>? ?: listOf()
    )

    private fun RemoteDailyForecastsItem.fromRemoteToDomain() = with(DataExtension) {
        DomainForecastItem(
            date = date?.formatDate() ?: "",
            min = temperature?.minimum?.imperial?.getImperialFormat() ?: "",
            max = temperature?.maximum?.imperial?.getImperialFormat() ?: "",
            dayIcon = getUrlIcon(day?.icon ?: 0),
            nightIcon = getUrlIcon(night?.icon ?: 0)
        )
    }
}