package com.anibalbastias.demo

import android.os.Bundle
import android.view.View
import com.anibalbastias.demo.base.fragment.BaseContainerFragment
import com.anibalbastias.weatherlib.WeatherManager
import com.anibalbastias.weatherlib.presentation.contract.WeatherListener
import com.anibalbastias.weatherlib.presentation.model.WeatherCurrentCondition
import com.anibalbastias.weatherlib.presentation.model.WeatherForecast
import com.anibalbastias.weatherlib.presentation.model.WeatherGeoLocation

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
                    TODO("Not yet implemented")
                }

                override fun onGetGeoLocationError(message: String) {
                    TODO("Not yet implemented")
                }

                override fun onGetCurrentConditionsSuccess(currentConditions: WeatherCurrentCondition) {
                    TODO("Not yet implemented")
                }

                override fun onGetCurrentConditionsError(message: String) {
                    TODO("Not yet implemented")
                }

                override fun onGet1DayForecastSuccess(currentConditions: WeatherForecast) {
                    TODO("Not yet implemented")
                }

                override fun onGet1DayForecastError(message: String) {
                    TODO("Not yet implemented")
                }

                override fun onGet5DayForecastSuccess(currentConditions: WeatherForecast) {
                    TODO("Not yet implemented")
                }

                override fun onGet5DayForecastError(message: String) {
                    TODO("Not yet implemented")
                }
            })
    }
}
