package com.anibalbastias.weatherlib

import android.app.Application
import com.anibalbastias.weatherlib.data.dataModule
import com.anibalbastias.weatherlib.domain.domainModule
import com.anibalbastias.weatherlib.domain.usecase.Get1DayDailyForecastsUseCase
import com.anibalbastias.weatherlib.domain.usecase.Get5DayDailyForecastsUseCase
import com.anibalbastias.weatherlib.domain.usecase.GetCurrentConditionsUseCase
import com.anibalbastias.weatherlib.domain.usecase.GetGeoPositionUseCase
import com.anibalbastias.weatherlib.presentation.contract.WeatherListener
import com.anibalbastias.weatherlib.presentation.mapper.WeatherCurrentConditionMapper
import com.anibalbastias.weatherlib.presentation.mapper.WeatherForecastMapper
import com.anibalbastias.weatherlib.presentation.mapper.WeatherGeoLocationMapper
import com.anibalbastias.weatherlib.presentation.presentationModule
import kotlinx.coroutines.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.instance

class WeatherManager(application: Application) : KodeinAware {

    private var weatherCallback: WeatherListener? = null

    private val getGeoPositionUseCase: GetGeoPositionUseCase by instance()
    private val getCurrentConditionsUseCase: GetCurrentConditionsUseCase by instance()
    private val get1DayDailyForecastsUseCase: Get1DayDailyForecastsUseCase by instance()
    private val get5DayDailyForecastsUseCase: Get5DayDailyForecastsUseCase by instance()

    private val weatherCurrentConditionMapper: WeatherCurrentConditionMapper by instance()
    private val weatherForecastMapper: WeatherForecastMapper by instance()
    private val weatherGeoLocationMapper: WeatherGeoLocationMapper by instance()

    companion object {
        const val MODULE_NAME = "WEATHER"
    }

    override val kodein = Kodein.lazy {
        import(androidXModule(application))
        import(presentationModule)
        import(domainModule)
        import(dataModule)
        import(appModule)
    }

    fun getCurrentWeather(
        latitude: Double,
        longitude: Double,
        callback: WeatherListener
    ) {
        weatherCallback = callback

        MainScope().launch {
            try {
                getGeoPositionUseCase.execute("$latitude,$longitude")?.also {
                    if (it.cityKey.isNotEmpty()) {
                        with(weatherGeoLocationMapper) {
                            weatherCallback?.onGetGeoLocationSuccess(it.fromDomainToUi())
                        }

                        getCurrentConditions(it.cityKey)
                        get1DayForecast(it.cityKey)
                        get5DayForecast(it.cityKey)
                    } else {
                        weatherCallback?.onGetGeoLocationError("Error")
                    }
                }
            } catch (e: Exception) {
                weatherCallback?.onGetGeoLocationError(e.message ?: "Error")
            }
        }
    }

    private fun getCurrentConditions(cityKey: String) {
        MainScope().launch {
            try {
                getCurrentConditionsUseCase.execute(cityKey)?.also {
                    if (it.currentDate.isNotEmpty()) {
                        with(weatherCurrentConditionMapper) {
                            weatherCallback?.onGetCurrentConditionsSuccess(it.fromDomainToUi())
                        }
                    } else {
                        weatherCallback?.onGetCurrentConditionsError("Error")
                    }
                }
            } catch (e: Exception) {
                weatherCallback?.onGetCurrentConditionsError(e.message ?: "Error")
            }
        }
    }

    private fun get1DayForecast(cityKey: String) {
        MainScope().launch {
            try {
                get1DayDailyForecastsUseCase.execute(cityKey)?.also {
                    if (it.title.isNotEmpty()) {
                        with(weatherForecastMapper) {
                            weatherCallback?.onGet1DayForecastSuccess(it.fromDomainToUi())
                        }
                    } else {
                        weatherCallback?.onGet1DayForecastError("Error")
                    }
                }
            } catch (e: Exception) {
                weatherCallback?.onGet1DayForecastError(e.message ?: "Error")
            }
        }
    }

    private fun get5DayForecast(cityKey: String) {
        MainScope().launch {
            try {
                get5DayDailyForecastsUseCase.execute(cityKey)?.also {
                    if (it.title.isNotEmpty()) {
                        with(weatherForecastMapper) {
                            weatherCallback?.onGet5DayForecastSuccess(it.fromDomainToUi())
                        }
                    } else {
                        weatherCallback?.onGet5DayForecastError("Error")
                    }
                }
            } catch (e: Exception) {
                weatherCallback?.onGet5DayForecastError(e.message ?: "Error")
            }
        }
    }
}