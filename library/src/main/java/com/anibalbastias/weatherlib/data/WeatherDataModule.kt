package com.anibalbastias.weatherlib.data

import com.anibalbastias.weatherlib.WeatherManager.Companion.MODULE_NAME
import com.anibalbastias.weatherlib.data.mapper.CurrentConditionsMapper
import com.anibalbastias.weatherlib.data.mapper.ForecastMapper
import com.anibalbastias.weatherlib.data.mapper.GeoPositionMapper
import com.anibalbastias.weatherlib.data.repository.WeatherRepositoryImpl
import com.anibalbastias.weatherlib.data.retrofit.service.WeatherService
import com.anibalbastias.weatherlib.domain.repository.WeatherRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

internal val dataModule = Kodein.Module("${MODULE_NAME}DataModule") {

    bind<WeatherRepository>() with singleton {
        WeatherRepositoryImpl(
            instance(),
            instance(),
            instance(),
            instance()
        )
    }

    bind() from singleton { instance<Retrofit>().create(WeatherService::class.java) }

    bind() from singleton { GeoPositionMapper() }

    bind() from singleton { CurrentConditionsMapper() }

    bind() from singleton { ForecastMapper() }

}
