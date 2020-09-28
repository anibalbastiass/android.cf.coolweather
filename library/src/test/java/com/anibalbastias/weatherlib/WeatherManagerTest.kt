package com.anibalbastias.weatherlib

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.anibalbastias.testutils.CoroutineRule
import com.anibalbastias.testutils.foundation.RandomFactory
import com.anibalbastias.testutils.foundation.RandomFactory.generateInt
import com.anibalbastias.weatherlib.domain.usecase.Get1DayDailyForecastsUseCase
import com.anibalbastias.weatherlib.domain.usecase.Get5DayDailyForecastsUseCase
import com.anibalbastias.weatherlib.domain.usecase.GetCurrentConditionsUseCase
import com.anibalbastias.weatherlib.domain.usecase.GetGeoPositionUseCase
import com.anibalbastias.weatherlib.factory.CurrentConditionFactory
import com.anibalbastias.weatherlib.factory.ForecastFactory
import com.anibalbastias.weatherlib.factory.GeoLocationFactory
import com.anibalbastias.weatherlib.presentation.contract.WeatherListener
import com.anibalbastias.weatherlib.presentation.mapper.WeatherCurrentConditionMapper
import com.anibalbastias.weatherlib.presentation.mapper.WeatherForecastMapper
import com.anibalbastias.weatherlib.presentation.mapper.WeatherGeoLocationMapper
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class WeatherManagerTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutineRule()

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @MockK
    internal lateinit var getGeoPositionUseCase: GetGeoPositionUseCase

    @MockK
    internal lateinit var getCurrentConditionsUseCase: GetCurrentConditionsUseCase

    @MockK
    internal lateinit var get1DayDailyForecastsUseCase: Get1DayDailyForecastsUseCase

    @MockK
    internal lateinit var get5DayDailyForecastsUseCase: Get5DayDailyForecastsUseCase

    @MockK
    internal lateinit var weatherCallback: WeatherListener

    private lateinit var weatherGeoLocationMapper: WeatherGeoLocationMapper
    private lateinit var weatherCurrentConditionMapper: WeatherCurrentConditionMapper
    private lateinit var weatherForecastMapper: WeatherForecastMapper
    private lateinit var cut: WeatherManager

    private val mApplicationMock = mockk<Application>(relaxed = true)

    private var latitude: Double = 0.0
    private var longitude: Double = 0.0

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        weatherCurrentConditionMapper = WeatherCurrentConditionMapper()
        weatherForecastMapper = WeatherForecastMapper()
        weatherGeoLocationMapper = WeatherGeoLocationMapper()
        cut = WeatherManager(mApplicationMock)

        latitude = RandomFactory.generateDouble()
        longitude = RandomFactory.generateDouble()
    }

    @Test
    fun `verify state when GetGeoPositionUseCase returns Error`() {
        // given
        val cityKey = "${generateInt()}"
        val domain = GeoLocationFactory.makeDomainGeoLocation()

        coEvery { getGeoPositionUseCase.execute(cityKey) } returns domain

        // when
        cut.getCurrentWeather(latitude, longitude, weatherCallback)
        cut.weatherCallback = weatherCallback
    }

    @Test
    fun `verify state when GetCurrentConditionsUseCase returns Error`() {
        // given
        val cityKey = "${generateInt()}"
        val domain = CurrentConditionFactory.makeDomainCurrentCondition()

        coEvery { getCurrentConditionsUseCase.execute(cityKey) } returns domain

        // when
        cut.getCurrentWeather(latitude, longitude, weatherCallback)
        cut.getCurrentConditions(cityKey)
        cut.weatherCallback = weatherCallback
    }

    @Test
    fun `verify state when Get1DayDailyForecastsUseCase returns Error`() {
        // given
        val cityKey = "${generateInt()}"
        val domain = ForecastFactory.makeDomainForecast()

        coEvery { get1DayDailyForecastsUseCase.execute(cityKey) } returns domain

        // when
        cut.getCurrentWeather(latitude, longitude, weatherCallback)
        cut.get1DayForecast(cityKey)
        cut.weatherCallback = weatherCallback
    }

    @Test
    fun `verify state when Get5DayDailyForecastsUseCase returns Error`() {
        // given
        val cityKey = "${generateInt()}"
        val domain = ForecastFactory.makeDomainForecast()

        coEvery { get5DayDailyForecastsUseCase.execute(cityKey) } returns domain

        // when
        cut.getCurrentWeather(latitude, longitude, weatherCallback)
        cut.get5DayForecast(cityKey)
        cut.weatherCallback = weatherCallback
    }
}