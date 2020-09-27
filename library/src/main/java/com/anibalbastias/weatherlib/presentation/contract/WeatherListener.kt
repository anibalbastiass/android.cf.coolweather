package com.anibalbastias.weatherlib.presentation.contract

import com.anibalbastias.weatherlib.presentation.model.WeatherCurrentCondition
import com.anibalbastias.weatherlib.presentation.model.WeatherForecast
import com.anibalbastias.weatherlib.presentation.model.WeatherGeoLocation

interface WeatherListener {
    fun onGetGeoLocationSuccess(geoLocation: WeatherGeoLocation)
    fun onGetGeoLocationError(message: String)

    fun onGetCurrentConditionsSuccess(currentConditions: WeatherCurrentCondition)
    fun onGetCurrentConditionsError(message: String)

    fun onGet1DayForecastSuccess(currentConditions: WeatherForecast)
    fun onGet1DayForecastError(message: String)

    fun onGet5DayForecastSuccess(currentConditions: WeatherForecast)
    fun onGet5DayForecastError(message: String)
}