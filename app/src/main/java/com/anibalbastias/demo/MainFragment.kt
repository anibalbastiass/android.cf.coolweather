package com.anibalbastias.demo

import android.os.Bundle
import android.view.View
import com.anibalbastias.demo.base.extension.ViewExtension.setImageUrl
import com.anibalbastias.demo.base.fragment.BaseContainerFragment
import com.anibalbastias.weatherlib.WeatherManager
import com.anibalbastias.weatherlib.presentation.contract.WeatherListener
import com.anibalbastias.weatherlib.presentation.model.WeatherCurrentCondition
import com.anibalbastias.weatherlib.presentation.model.WeatherForecast
import com.anibalbastias.weatherlib.presentation.model.WeatherGeoLocation
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseContainerFragment() {

    override val layoutResourceId = R.layout.fragment_main
    lateinit var manager: WeatherManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        manager = WeatherManager(MainApplication.application)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        manager.getCurrentWeather(-33.5346427, -70.630751,
            object: WeatherListener {
                override fun onGetGeoLocationSuccess(geoLocation: WeatherGeoLocation) {
                    val fullLocation: String = geoLocation.run { "$cityName, $parentCity, $areaName, $country" }
                    tvLocation?.text = fullLocation
                }

                override fun onGetGeoLocationError(message: String) {
                    
                }

                override fun onGetCurrentConditionsSuccess(currentConditions: WeatherCurrentCondition) {
                    currentConditions.apply {
                        ivWeatherIcon?.setImageUrl(weatherIcon)
                        tvCurrentTemperature?.text = currentTemperature
                        tvRealFeelTemperature?.text = getString(R.string.real_feel, realFeelTemperature)
                        tvDirectionWindValue?.text = directionWind
                        tvSpeedWindValue?.text = speedWind
                        tvRelativeHumidityValue?.text = relativeHumidity
                        tvPressureValue?.text = pressure
                        tvPrecipitationSummaryValue?.text = precipitationSummary
                    }
                }

                override fun onGetCurrentConditionsError(message: String) {
                    
                }

                override fun onGet1DayForecastSuccess(currentConditions: WeatherForecast) {
                    
                }

                override fun onGet1DayForecastError(message: String) {
                    
                }

                override fun onGet5DayForecastSuccess(currentConditions: WeatherForecast) {
                    
                }

                override fun onGet5DayForecastError(message: String) {
                    
                }
            })
    }
}
