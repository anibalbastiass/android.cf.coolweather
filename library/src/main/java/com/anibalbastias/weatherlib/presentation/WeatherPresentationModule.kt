package com.anibalbastias.weatherlib.presentation

import com.anibalbastias.weatherlib.WeatherManager.Companion.MODULE_NAME
import com.anibalbastias.weatherlib.presentation.mapper.WeatherCurrentConditionMapper
import com.anibalbastias.weatherlib.presentation.mapper.WeatherForecastMapper
import com.anibalbastias.weatherlib.presentation.mapper.WeatherGeoLocationMapper
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

internal val presentationModule = Kodein.Module("${MODULE_NAME}PresentationModule") {

    bind() from singleton { WeatherCurrentConditionMapper() }

    bind() from singleton { WeatherForecastMapper() }

    bind() from singleton { WeatherGeoLocationMapper() }

}
