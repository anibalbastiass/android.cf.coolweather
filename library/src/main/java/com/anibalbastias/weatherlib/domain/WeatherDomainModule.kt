package com.anibalbastias.weatherlib.domain

import com.anibalbastias.weatherlib.WeatherManager.Companion.MODULE_NAME
import com.anibalbastias.weatherlib.domain.usecase.Get1DayDailyForecastsUseCase
import com.anibalbastias.weatherlib.domain.usecase.Get5DayDailyForecastsUseCase
import com.anibalbastias.weatherlib.domain.usecase.GetCurrentConditionsUseCase
import com.anibalbastias.weatherlib.domain.usecase.GetGeoPositionUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

internal val domainModule = Kodein.Module("${MODULE_NAME}DomainModule") {

    bind() from singleton { Get1DayDailyForecastsUseCase(instance()) }

    bind() from singleton { Get5DayDailyForecastsUseCase(instance()) }

    bind() from singleton { GetCurrentConditionsUseCase(instance()) }

    bind() from singleton { GetGeoPositionUseCase(instance()) }

}
